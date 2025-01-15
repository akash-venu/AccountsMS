package com.teckarch.AccountsMS.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "account_number", nullable = false,unique = true, length = 20)
    private String accountNumber;
    @Column(name = "account_type", nullable = false, length = 20)
    private String accountType;
    @Column(name = "currency",length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'USD'")
    private String currency;
    @Column(name = "balance", columnDefinition = "DECIMAL(15,2) DEFAULT 0.0")
    private double balance;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }


}
