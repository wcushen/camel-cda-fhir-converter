package com.fhir.app;

import org.apache.camel.builder.RouteBuilder;

public class CdaToFhirRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:cdaToFhir")
            .log("Converting CDA to FHIR")
            .to("fhir:create/resource?inBody=resourceAsString&serverUrl=https://fhir-route-hapi-fhir.apps.cluster-d6c6j.dynamic.redhatworkshops.io/fhir&fhirVersion=R4")
            .log("Conversion complete");
    }
}

