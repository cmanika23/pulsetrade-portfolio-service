package com.pulsetrade.portfolio_service.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HoldingsResponse {

    @NotBlank
    private Long holdingId;
    @NotBlank
    private String symbol;
    @NotBlank
    private Long portfolioId;
    private String name;
    private String exchange;
    @NotBlank
    private Integer quantity;
    private BigDecimal averageBuyPrice;
    private BigDecimal currentPrice;
    private BigDecimal marketValue;
    private BigDecimal gainLoss;
    private BigDecimal weight;
    private String sector;
    private String assetType;
    private LocalDateTime purchaseDate;
    private Boolean dividendReinvestment;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
