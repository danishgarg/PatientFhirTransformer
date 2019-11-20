package com.athenahealth.quality.cdc.infrastructure.messaging;

import java.util.List;

import com.athenahealth.quality.cdc.domain.PatientCanonical;
import com.athenahealth.quality.cdc.domain.PatientChartFhirWrapper;
import com.athenahealth.quality.cdc.infrastructure.messaging.configuration.KafkaChannels;
import com.athenahealth.quality.cdc.infrastructure.messaging.messages.ChartCDCMessage;
import com.athenahealth.quality.cdc.infrastructure.messaging.messages.ChartTable;
import com.athenahealth.quality.cdc.infrastructure.messaging.messages.ClientCDCMessage;
import com.athenahealth.quality.cdc.infrastructure.messaging.messages.ClientTable;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(KafkaChannels.class)
public class KafkaStreamProcessor {
    @StreamListener
    @SendTo(KafkaChannels.CLIENT_CDC_SNAPSHOT_OUT)
    public KStream<String, ClientCDCMessage> processClientCDCEvents(
        @Input(KafkaChannels.CLIENT_CDC_INPUT) KStream<String, ClientCDCMessage> clients) {
            return clients
            .groupByKey()
            .reduce(
                (snapshot, cdcEvent) -> { return this.getClientSnapshot(snapshot, cdcEvent); }
            )
            .toStream();
    }

    @StreamListener
    @SendTo(KafkaChannels.CHART_CDC_SNAPSHOT_OUT)
    public KStream<String, ChartCDCMessage> processChartCDCEvents(
        @Input(KafkaChannels.CHART_CDC_INPUT) KStream<String, ChartCDCMessage> charts) {
            return charts
            .groupByKey()
            .reduce(
                (snapshot, cdcEvent) -> { return this.getChartSnapshot(snapshot, cdcEvent); }
            )
            .toStream();
    }

    @StreamListener
    @SendTo(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_OUT_CLIENT_JOIN)
    public KStream<String, PatientCanonical> applyClientUpdates(
        @Input(KafkaChannels.CLIENT_CDC_SNAPSHOT_IN) KStream<String, ClientCDCMessage> clients,
        @Input(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_IN_TABLE_CLIENT_JOIN) KTable<String, PatientCanonical> patientsTable) {
            return clients
            .peek((key, value) -> System.out.println("Received patient cdc snapshot with key" + key + " value: " + value))
            .filter((key, value) -> value != null && value.getAfter() != null && value.getAfter().getENTERPRISEID() != null)
            .selectKey((key, value) -> value.getAfter().getENTERPRISEID())
            .leftJoin(patientsTable, (client, patient) -> this.UpdatePatientCanonicalForClient(client,patient))
            .peek((key, value) -> System.out.println("publishing patient canonical with key" + key + " value: " + value));
    }

    @StreamListener
    @SendTo(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_OUT_CHART_JOIN)
    public KStream<String, PatientCanonical> applyChartUpdates(
        @Input(KafkaChannels.CHART_CDC_SNAPSHOT_IN) KStream<String, ChartCDCMessage> charts,
        @Input(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_IN_TABLE_CHART_JOIN) KTable<String, PatientCanonical> patientsTable) {
            return charts
            .peek((key, value) -> System.out.println("Received chart cdc snapshot with key" + key + " value: " + value))
            .filter((key, value) -> value != null && value.getAfter() != null && value.getAfter().getENTERPRISEID() != null)
            .selectKey((key, value) -> value.getAfter().getENTERPRISEID())
            .leftJoin(patientsTable, (chart, patient) -> this.UpdatePatientCanonicalForChart(chart,patient))
            .peek((key, value) -> System.out.println("publishing patient canonical with key" + key + " value: " + value));
    }

    @StreamListener
    @SendTo(KafkaChannels.PATIENT_FHIR_OUT)
    public KStream<String, PatientChartFhirWrapper> transformToPatientFhir(
        @Input(KafkaChannels.PATIENT_CANONICAL_SNAPSHOT_IN_STREAM) KStream<String, PatientCanonical> patientsStream) {
            return patientsStream
            .peek((key, value) -> System.out.println("Received patient canonical record with key" + key + " value: " + value))
            .flatMapValues((key, value) -> this.getPatientFhirRecords(value));
    }

    private List<PatientChartFhirWrapper> getPatientFhirRecords(PatientCanonical patientCanonical) {
        return patientCanonical.createFhirWrappers();
    }

    private PatientCanonical UpdatePatientCanonicalForChart(ChartCDCMessage chart, PatientCanonical patient) {
        if (patient == null) {
            patient = new PatientCanonical(chart.getAfter().getENTERPRISEID());
        }
        patient.applyChartUpdate(chart);
        return patient;
    }
    private PatientCanonical UpdatePatientCanonicalForClient(ClientCDCMessage client, PatientCanonical patient) {
        if (patient == null) {
            patient = new PatientCanonical(client.getAfter().getENTERPRISEID());    
        }
        patient.applyClientUpdate(client);
        return patient;
    }

    private ChartCDCMessage getChartSnapshot(ChartCDCMessage snapshot, ChartCDCMessage cdcEvent) {
        //Tombstone
        if(cdcEvent.getOp_type() == "D" || cdcEvent.getAfter() == null) {
            return null;
        }
        ChartTable newSnapshot = snapshot.getAfter() == null ? new ChartTable() : snapshot.getAfter();
        ChartTable before = cdcEvent.getOp_type().equals("I") ? new ChartTable() : cdcEvent.getBefore();
        ChartTable after = cdcEvent.getAfter();
        newSnapshot.setCHARTSHARINGGROUPID(this.MergeChanges(before.getCHARTSHARINGGROUPID(), after.getCHARTSHARINGGROUPID(), newSnapshot.getCHARTSHARINGGROUPID()));
        newSnapshot.setENTERPRISEID(this.MergeChanges(before.getENTERPRISEID(), after.getENTERPRISEID(), newSnapshot.getENTERPRISEID()));
        newSnapshot.setCREATED(this.MergeChanges(before.getCREATED(), after.getCREATED(), newSnapshot.getCREATED()));
        newSnapshot.setCREATEDBY(this.MergeChanges(before.getCREATEDBY(), after.getCREATEDBY(), newSnapshot.getCREATEDBY()));
        snapshot.setAfter(newSnapshot);
        return snapshot;
    }

    private ClientCDCMessage getClientSnapshot(ClientCDCMessage agg, ClientCDCMessage cdcEvent) {
        //Tombstone
        if(cdcEvent.getOp_type() == "D" || cdcEvent.getAfter() == null) {
            return null;
        }
        ClientTable newSnapshot = agg.getAfter() == null ? new ClientTable() : agg.getAfter();
        ClientTable before = cdcEvent.getOp_type().equals("I") ? new ClientTable() : cdcEvent.getBefore();
        ClientTable after = cdcEvent.getAfter();
        newSnapshot.setFIRSTNAME(this.MergeChanges(before.getFIRSTNAME(), after.getFIRSTNAME(), newSnapshot.getFIRSTNAME()));
        newSnapshot.setLASTNAME(this.MergeChanges(before.getLASTNAME(), after.getLASTNAME(), newSnapshot.getLASTNAME()));
        newSnapshot.setCREATED(this.MergeChanges(before.getCREATED(), after.getCREATED(), newSnapshot.getCREATED()));
        newSnapshot.setCREATEDBY(this.MergeChanges(before.getCREATEDBY(), after.getCREATEDBY(), newSnapshot.getCREATEDBY()));
        newSnapshot.setDOB(this.MergeChanges(before.getDOB(), after.getDOB(), newSnapshot.getDOB()));
        newSnapshot.setENTERPRISEID(this.MergeChanges(before.getENTERPRISEID(), after.getENTERPRISEID(), newSnapshot.getENTERPRISEID()));
        agg.setAfter(newSnapshot);
        return agg;
    }

    private String MergeChanges(String beforeValue, String afterValue, String newValue) {
        beforeValue = beforeValue == null ? "NULL" : beforeValue;
        afterValue = afterValue == null ? "NULL" : afterValue;
        if (!beforeValue.equals(afterValue)) {
            newValue = afterValue.equals("NULL") ? null : afterValue;
        }
        return newValue;
    }
}