package com.universidad.service;

import java.math.BigDecimal;

// Lo que el cliente envía
class PaymentRequest {
    private BigDecimal amount;
    private String reference;

    public PaymentRequest() {}
    public PaymentRequest(BigDecimal amount, String reference) {
        this.amount = amount;
        this.reference = reference;
    }
    public BigDecimal getAmount() { return amount; }
    public String getReference() { return reference; }
}

// Lo que el servidor responde
class PaymentResponse {
    private String status;
    private String transactionId;

    public PaymentResponse(String status, String transactionId) {
        this.status = status;
        this.transactionId = transactionId;
    }
    public String getStatus() { return status; }
    public String getTransactionId() { return transactionId; }
}