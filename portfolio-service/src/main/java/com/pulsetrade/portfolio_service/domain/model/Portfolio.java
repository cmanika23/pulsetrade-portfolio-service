package com.pulsetrade.portfolio_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {

    private Long userId;
    private String name;

    private String type; // e.g., "Taxable", "401k", "Roth IRA", etc.
    private String currency; // e.g., "USD", "EUR"
    private BigDecimal totalValue;
    private BigDecimal cashBalance;
    private String riskProfile; // "Conservative", "Moderate", "Aggressive"
    private String strategy; // "Growth", "Income", "Balanced"
    private String advisor; // optional
    private List<Holding> holdings;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
