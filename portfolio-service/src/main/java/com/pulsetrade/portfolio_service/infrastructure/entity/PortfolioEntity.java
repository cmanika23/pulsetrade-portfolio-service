package com.pulsetrade.portfolio_service.infrastructure.entity;

import com.pulsetrade.portfolio_service.domain.model.Holding;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "portfolios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id",nullable = false)
    private UUID userId; //reference to user service

    @Column(name = "name", nullable = false)
    private String name; // "Main Portfolio", "Retirement Fund", etc

    @Column(name = "type", nullable = false)
    private String type; // e.g., "Taxable", "401k", "Roth IRA", etc.

    @Column(name = "currency", nullable = false)
    private String currency; // e.g., "USD", "EUR"

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @Column(name = "cash_balance")
    private BigDecimal cashBalance;

    @Column(name = "risk_profile")
    private String riskProfile; // "Conservative", "Moderate", "Aggressive"

    @Column(name = "strategy")
    private String strategy; // "Growth", "Income", "Balanced"

    @Column(name = "advisor")
    private String advisor; // optional

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "holdings")
    private List<HoldingEntity> holdings;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

}
