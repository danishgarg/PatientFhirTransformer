package com.athenahealth.quality.cdc.infrastructure.messaging.serdes;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import org.hl7.fhir.dstu3.model.Patient;

public class PatientFhirSerializer extends JsonSerializer<Patient> {

    @Override
    public void serialize(Patient value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(FhirContextWrapper.getFhirContext().newJsonParser().encodeResourceToString(value));
    }

}