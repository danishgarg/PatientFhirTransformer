package com.athenahealth.quality.cdc.domain;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.athenahealth.quality.cdc.infrastructure.messaging.messages.ChartCDCMessage;
import com.athenahealth.quality.cdc.infrastructure.messaging.messages.ClientCDCMessage;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.hl7.fhir.dstu3.model.HumanName;
import org.hl7.fhir.dstu3.model.Identifier;
import org.hl7.fhir.dstu3.model.Patient;

@Data
@NoArgsConstructor
public class PatientCanonical {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String enterpriseId;
    private List<String> chartIds;
    private String createdTimestamp;
    private String createdBy;

    public PatientCanonical(String enterpriseid) {
        this.enterpriseId = enterpriseid;
	}
	public void applyClientUpdate(ClientCDCMessage client) {
        this.firstName = client.getAfter().getFIRSTNAME();
        this.lastName = client.getAfter().getLASTNAME();
        this.birthDate = client.getAfter().getDOB();
        this.enterpriseId = client.getAfter().getENTERPRISEID();
        this.createdTimestamp = client.getAfter().getCREATED();
        this.createdBy = client.getAfter().getCREATEDBY();
    }
    
    public void applyChartUpdate(ChartCDCMessage chart) {
        if(this.chartIds == null) {
            this.chartIds = new ArrayList<String>();
        }
        if(!this.chartIds.contains(chart.getAfter().getID())) {
            this.chartIds.add(chart.getAfter().getID());
        }
	}
	public List<PatientChartFhirWrapper> createFhirWrappers() {
        ArrayList<PatientChartFhirWrapper> wrappers = new ArrayList<>();
        if (this.chartIds == null || this.chartIds.size() == 0) {
            return wrappers;
        }
        Patient patientFhir = new Patient();
        HumanName name = new HumanName();
        if (this.getFirstName() != null && this.getFirstName().length() > 0) {
            name.addGiven(this.getFirstName());
            patientFhir.addName(name);
        }
        if(this.getLastName() != null && this.getLastName().length() > 0) {
            name.setFamily(this.getLastName());
        }
        if(this.getBirthDate() != null && this.getBirthDate().length() > 0) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime date = LocalDateTime.parse(this.getBirthDate(), formatter);
            patientFhir.setBirthDate(Date.valueOf(date.toLocalDate().toString()));
        }
        for (String chartId : this.chartIds) {
            if (chartId.length() > 0) {
                Patient chartCopy = patientFhir.copy();
                Identifier identifier = new Identifier();
                identifier.setSystem("athena.patient.chart");
                identifier.setValue(chartId);
                chartCopy.addIdentifier(identifier);
                wrappers.add(new PatientChartFhirWrapper(chartCopy, enterpriseId));
            }
        }
        return wrappers;
	}
}