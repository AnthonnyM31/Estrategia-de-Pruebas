package com.universidad.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class PaymentController {

    @PostMapping("/payments/authorize")
    public ResponseEntity<PaymentResponse> authorize(@RequestBody PaymentRequest request) {
        // Simulamos la lógica de negocio
        return ResponseEntity.ok(new PaymentResponse("AUTHORIZED", UUID.randomUUID().toString()));
    }
}