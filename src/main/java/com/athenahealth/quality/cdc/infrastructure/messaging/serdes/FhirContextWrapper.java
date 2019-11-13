package com.athenahealth.quality.cdc.infrastructure.messaging.serdes;

import ca.uhn.fhir.context.FhirContext;

public class FhirContextWrapper {

    private static final FhirContext fhirctx = FhirContext.forDstu3();

    public static FhirContext getFhirContext() {
        return fhirctx;
    }
}