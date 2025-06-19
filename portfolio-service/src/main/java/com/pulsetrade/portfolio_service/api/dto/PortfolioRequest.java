package com.pulsetrade.portfolio_service.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PortfolioRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String type;

    @NotBlank
    private String currency;

    private BigDecimal totalValue;

    private BigDecimal cashBalance;

    private String riskProfile;

    private String strategy;

    private String advisor;

}

