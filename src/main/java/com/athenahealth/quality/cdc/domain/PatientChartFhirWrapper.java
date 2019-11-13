package com.athenahealth.quality.cdc.domain;

import com.athenahealth.quality.cdc.infrastructure.messaging.serdes.PatientFhirDeserializer;
import com.athenahealth.quality.cdc.infrastructure.messaging.serdes.PatientFhirSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.hl7.fhir.dstu3.model.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientChartFhirWrapper {
    @JsonSerialize(using = PatientFhirSerializer.class)
    @JsonDeserialize(using = PatientFhirDeserializer.class)
    private Patient patientFhir;
    private String enterpriseId;
}