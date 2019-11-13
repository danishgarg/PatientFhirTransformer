package com.athenahealth.quality.cdc.infrastructure.messaging.serdes;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import org.hl7.fhir.dstu3.model.Patient;

public class PatientFhirDeserializer extends JsonDeserializer<Patient> {

    @Override
    public Patient deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        return FhirContextWrapper.getFhirContext().newJsonParser().parseResource(Patient.class,p.getValueAsString());
    }

}