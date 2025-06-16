package com.pulsetrade.portfolio_service.infrastructure.entity;

import com.pulsetrade.portfolio_service.domain.model.Portfolio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "holdings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoldingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private PortfolioEntity portfolio;

    @Column(name = "symbol", nullable = false)
    private String symbol; // e.g., "AAPL"

    @Column(name = "name")
    private String name; // e.g., "Apple Inc."

    @Column(name = "exchange")
    private String exchange; // e.g., "NASDAQ", "NYSE"

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "average_buy_price")
    private BigDecimal averageBuyPrice;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @Column(name = "market_value")
    private BigDecimal marketValue; // quantity × currentPrice

    @Column(name = "gain_loss")
    private BigDecimal gainLoss; // marketValue - (quantity × avgBuyPrice)

    @Column(name = "weight")
    private BigDecimal weight; // percentage of portfolio

    @Column(name = "sector")
    private String sector; // e.g., "Technology", "Healthcare"

    @Column(name = "asset_type")
    private String assetType; // e.g., "Stock", "ETF", "Bond"

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "dividend_reinvestment")
    private Boolean dividendReinvestment;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
