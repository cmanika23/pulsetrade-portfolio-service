package com.pulsetrade.portfolio_service.infrastructure.mapper;

import com.pulsetrade.portfolio_service.domain.model.Portfolio;
import com.pulsetrade.portfolio_service.infrastructure.entity.PortfolioEntity;
import org.springframework.stereotype.Component;

@Component
public class PortfolioMapper {

    public Portfolio toDomain(PortfolioEntity entity){
        return Portfolio.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .name(entity.getName())
                .type(entity.getType())
                .currency(entity.getCurrency())
                .totalValue(entity.getTotalValue())
                .cashBalance(entity.getCashBalance())
                .riskProfile(entity.getRiskProfile())
                .strategy(entity.getStrategy())
                .advisor(entity.getAdvisor())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public PortfolioEntity toEntity(Portfolio domain) {
        return PortfolioEntity.builder()
                .id(domain.getId())
                .userId(domain.getUserId())
                .name(domain.getName())
                .type(domain.getType())
                .currency(domain.getCurrency())
                .totalValue(domain.getTotalValue())
                .cashBalance(domain.getCashBalance())
                .riskProfile(domain.getRiskProfile())
                .strategy(domain.getStrategy())
                .advisor(domain.getAdvisor())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}
