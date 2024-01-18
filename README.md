# Camel CDA to FHIR Converter

This project provides a simple implementation of a CDA (Clinical Document Architecture) to FHIR (Fast Healthcare Interoperability Resources) converter using Apache Camel. It includes a Camel route that processes CDA XML data and transforms it into FHIR format.

## Prerequisites

Before running the converter, ensure you have the following prerequisites installed:

- [Java Development Kit (JDK)](https://adoptopenjdk.net/)
- [Apache Maven](https://maven.apache.org/)
- [Podman](https://podman.io/) (for building and running the container)
- [Git](https://git-scm.com/)

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/yourusername/camel-cda-fhir-converter.git
cd camel-cda-fhir-converter
```

### Build the Project

```bash
mvn clean install
```

### Build and Run the Podman Container

```bash
podman build -t camel-cda-fhir-converter .
podman run -p 8080:8080 -d camel-cda-fhir-converter
```

The Camel route will be accessible at http://localhost:8080/camel.

## Usage 

To convert CDA XML data to FHIR, use the provided Camel route. The conversion process is triggered by sending CDA data to the `direct:cdaToFhir` endpoint.

### Example Usage in Java

```bash
package com.fhir.app;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;

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

        // Dummy CDA test data
        String cdaTestData = "<Patient>...data...</Patient>";

        // Send CDA test data to the route
        producerTemplate.sendBody("direct:cdaToFhir", cdaTestData);

        // Stop CamelContext
        camelContext.stop();
    }
}
```

## CDA to FHIR Conversion Process

The conversion process involves the following steps:

1. **CDA XML Input**: The CDA XML data is provided as input.
2. **Apache Camel Route**: The Camel route processes the CDA data using a processor that converts it into FHIR format.
3. **FHIR Output**: The transformed FHIR data is made available at the specified Camel endpoint ([http://localhost:8080/fhir](http://localhost:8080/fhir)).

## Targeted FHIR Server

The transformed FHIR data is sent to a FHIR server running on OpenShift, deployed as part of a separate, standalone deployment.

## Viewing the Result

After sending the CDA data to the `direct:cdaToFhir` endpoint, check the final result. A screenshot of the final output is provided in the repository. 

Output shown below.

![FHIR_HTTP_200](https://github.com/wcushen/camel-cda-fhir-converter/main/200_screenshot.img?raw=true)

## Contributing

Feel free to contribute to this project by opening issues or submitting pull requests. Your contributions are highly appreciated.
