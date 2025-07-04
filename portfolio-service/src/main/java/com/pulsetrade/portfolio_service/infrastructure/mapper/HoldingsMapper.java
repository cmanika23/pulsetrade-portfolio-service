package com.pulsetrade.portfolio_service.infrastructure.mapper;

import com.pulsetrade.portfolio_service.api.dto.HoldingsRequest;
import com.pulsetrade.portfolio_service.api.dto.HoldingsResponse;
import com.pulsetrade.portfolio_service.domain.model.Holding;
import com.pulsetrade.portfolio_service.infrastructure.entity.HoldingEntity;
import org.springframework.stereotype.Component;

@Component
public class HoldingsMapper {

    public Holding toDomain(HoldingEntity entity){
        return  Holding.builder()
                .id(entity.getId())
                .symbol(entity.getSymbol())
                .name(entity.getName())
                .exchange(entity.getExchange())
                .quantity(entity.getQuantity())
                .averageBuyPrice(entity.getAverageBuyPrice())
                .currentPrice(entity.getCurrentPrice())
                .marketValue(entity.getMarketValue())
                .gainLoss(entity.getGainLoss())
                .weight(entity.getWeight())
                .sector(entity.getSector())
                .assetType(entity.getAssetType())
                .purchaseDate(entity.getPurchaseDate())
                .dividendReinvestment(entity.getDividendReinvestment())
                .notes(entity.getNotes())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    public Holding toDomain(HoldingsRequest request){
        return Holding.builder()
                .symbol(request.getSymbol())
                .name(request.getName())
                .exchange(request.getExchange())
                .quantity(request.getQuantity())
                .averageBuyPrice(request.getAverageBuyPrice())
                .currentPrice(request.getCurrentPrice())
                .weight(request.getWeight())
                .sector(request.getSector())
                .assetType(request.getAssetType())
                .purchaseDate(request.getPurchaseDate())
                .dividendReinvestment(request.getDividendReinvestment())
                .notes(request.getNotes())
                .build();
    }

    public HoldingEntity toEntity(Holding domain){
        return HoldingEntity.builder()
                .id(domain.getId())
                .portfolio(new PortfolioMapper().toEntity(domain.getPortfolio()))
                .symbol(domain.getSymbol())
                .name(domain.getName())
                .exchange(domain.getExchange())
                .quantity(domain.getQuantity())
                .averageBuyPrice(domain.getAverageBuyPrice())
                .currentPrice(domain.getCurrentPrice())
                .marketValue(domain.getMarketValue())
                .gainLoss(domain.getGainLoss())
                .weight(domain.getWeight())
                .sector(domain.getSector())
                .assetType(domain.getAssetType())
                .purchaseDate(domain.getPurchaseDate())
                .dividendReinvestment(domain.getDividendReinvestment())
                .notes(domain.getNotes())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }

    public HoldingsResponse toResponse(Holding domain){
        return HoldingsResponse.builder()
                .holdingId(domain.getId())
                .portfolioId(new PortfolioMapper().toEntity(domain.getPortfolio()).getId())
                .symbol(domain.getSymbol())
                .name(domain.getName())
                .exchange(domain.getExchange())
                .quantity(domain.getQuantity())
                .averageBuyPrice(domain.getAverageBuyPrice())
                .currentPrice(domain.getCurrentPrice())
                .marketValue(domain.getMarketValue())
                .gainLoss(domain.getGainLoss())
                .weight(domain.getWeight())
                .sector(domain.getSector())
                .assetType(domain.getAssetType())
                .purchaseDate(domain.getPurchaseDate())
                .dividendReinvestment(domain.getDividendReinvestment())
                .notes(domain.getNotes())
                .createdAt(domain.getCreatedAt())
                .updatedAt(domain.getUpdatedAt())
                .build();
    }
}
