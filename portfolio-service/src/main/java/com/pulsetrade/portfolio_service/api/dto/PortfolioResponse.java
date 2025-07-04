package com.pulsetrade.portfolio_service.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PortfolioResponse {
    private Long id;

    private UUID userId;

    private String name;

    private String type;

    private String currency;

    private BigDecimal totalValue;

    private BigDecimal cashBalance;

    private String riskProfile;

    private String strategy;

    private String advisor;
}
