package com.pulsetrade.portfolio_service.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class HoldingsRequest {

    @NotBlank
    private String symbol;
    @NotBlank
    private Integer portfolioId;
    private String name;
    private String exchange;
    @NotBlank
    private Integer quantity;
    private BigDecimal averageBuyPrice;
    private BigDecimal currentPrice;
    private BigDecimal weight;
    private String sector;
    private String assetType;
    private LocalDateTime purchaseDate;
    private Boolean dividendReinvestment;
    private String notes;

}
