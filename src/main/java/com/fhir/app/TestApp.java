package com.fhir.app;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

import java.io.InputStream;

public class TestApp {

    public static void main(String[] args) throws Exception {
        // Create CamelContext
        CamelContext camelContext = new DefaultCamelContext();

        // Add the route
        camelContext.addRoutes(new CdaToFhirRoute());

        // Start CamelContext
        camelContext.start();

        // Create ProducerTemplate
        ProducerTemplate producerTemplate = camelContext.createProducerTemplate();

        // Load the XML file from the classpath
        InputStream inputStream = TestApp.class.getClassLoader().getResourceAsStream("cda-data.xml");
        String cdaTestData = org.apache.commons.io.IOUtils.toString(inputStream, "UTF-8");

        // Send CDA test data to the route
        producerTemplate.sendBody("direct:cdaToFhir", cdaTestData);

        // Stop CamelContext
        camelContext.stop();
    }
}

