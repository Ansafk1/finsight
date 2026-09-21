package com.finsight.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transactions")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue
    private UUID id;
    private BigDecimal amount;
    private String merchantCategory;
    private String cardCountry;
    private Integer hourOfDay;
    private BigDecimal distanceFromHome;
    private BigDecimal fraudProbability;
    private Boolean isFlagged;
    private String llmExplanation;
    private LocalDateTime createdAt;

}
