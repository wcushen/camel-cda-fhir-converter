package com.fhir.app;

import org.apache.camel.builder.RouteBuilder;

public class CdaToFhirRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:cdaToFhir")
            .log("Converting CDA to FHIR")
	    .setProperty("fhir.server.url", simple("{{FHIR_SERVER_URL}}"))
            .to("fhir:create/resource?inBody=resourceAsString&serverUrl={{fhir.server.url}}&fhirVersion=R4")
            .log("Conversion complete");
    }
}
