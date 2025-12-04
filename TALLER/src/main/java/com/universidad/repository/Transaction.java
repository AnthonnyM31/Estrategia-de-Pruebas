package com.universidad.repository;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;
    
    private String description;
    
    private LocalDateTime date;

    // Constructor vacío (obligatorio para JPA)
    public Transaction() {}

    // Constructor útil
    public Transaction(BigDecimal amount, String description, LocalDateTime date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    // Getters
    public Long getId() { return id; }
    public BigDecimal getAmount() { return amount; }
    public String getDescription() { return description; }
    public LocalDateTime getDate() { return date; }
}