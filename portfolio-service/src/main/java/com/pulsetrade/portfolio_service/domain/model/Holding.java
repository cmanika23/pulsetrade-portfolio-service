package com.pulsetrade.portfolio_service.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Holding {
    private Long id;
    private Portfolio portfolio;
    private String symbol; // e.g., "AAPL"
    private String name; // e.g., "Apple Inc."
    private String exchange; // e.g., "NASDAQ", "NYSE"
    private Integer quantity;
    private BigDecimal averageBuyPrice;
    private BigDecimal currentPrice;
    private BigDecimal marketValue; // quantity × currentPrice
    private BigDecimal gainLoss; // marketValue - (quantity × avgBuyPrice)
    private BigDecimal weight; // percentage of portfolio
    private String sector; // e.g., "Technology", "Healthcare"
    private String assetType; // e.g., "Stock", "ETF", "Bond"
    private LocalDateTime purchaseDate;
    private Boolean dividendReinvestment;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
