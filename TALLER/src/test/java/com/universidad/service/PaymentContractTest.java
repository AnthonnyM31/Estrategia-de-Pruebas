package com.universidad.service;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactBuilder;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

@ExtendWith(PactConsumerTestExt.class)
@PactTestFor(providerName = "PaymentService")
class PaymentContractTest {

    @Pact(consumer = "FrontendApp")
    public V4Pact createPact(PactBuilder builder) {
        // Usamos usingLegacyDsl() para mantener la sintaxis sencilla que ya teníamos
        return builder.usingLegacyDsl()
            .given("payment service is available")
            .uponReceiving("a request to authorize a payment")
                .path("/payments/authorize")
                .method("POST")
                .body("{\"amount\": 100.00, \"reference\": \"REF-123\"}")
            .willRespondWith()
                .status(200)
                .body("{\"status\": \"AUTHORIZED\"}")
            .toPact(V4Pact.class); // <--- Esto es clave: Convertimos explícitamente a V4
    }

    @Test
    void testPaymentContract(MockServer mockServer) {
        // Configuramos el cliente HTTP para apuntar al servidor falso de Pact
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri(mockServer.getUrl())
                .build();

        // Creamos la petición real
        PaymentRequest request = new PaymentRequest(new BigDecimal("100.00"), "REF-123");
        
        // Ejecutamos la llamada
        ResponseEntity<String> response = restTemplate.postForEntity(
                "/payments/authorize",
                request,
                String.class
        );

        // Verificamos que la respuesta sea la acordada en el contrato
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertTrue(response.getBody().contains("AUTHORIZED"));
    }
}