package com.pulsetrade.portfolio_service.application.service;

import com.pulsetrade.portfolio_service.api.dto.PortfolioRequest;
import com.pulsetrade.portfolio_service.api.dto.PortfolioResponse;
import com.pulsetrade.portfolio_service.domain.model.Portfolio;
import com.pulsetrade.portfolio_service.domain.repository.IPortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService{

    private final IPortfolioRepository portfolioRepo;

    @Override
    public List<PortfolioResponse> getPortfoliosByUserId(UUID userID) {

        List<Portfolio> portfolios = portfolioRepo.findByUserId(userID);

        return portfolios.stream().map(portfolio -> {
            PortfolioResponse response = PortfolioResponse.builder()
                    .id(portfolio.getId())
                    .userId(portfolio.getUserId())
                    .name(portfolio.getName())
                    .type(portfolio.getType())
                    .currency(portfolio.getCurrency())
                    .totalValue(portfolio.getTotalValue())
                    .cashBalance(portfolio.getCashBalance())
                    .riskProfile(portfolio.getRiskProfile())
                    .strategy(portfolio.getStrategy())
                    .advisor(portfolio.getAdvisor())
                    .build();
            return response;
        }).toList();
    }

    @Override
    public Portfolio createPortfolio(PortfolioRequest portfolioRequest, UUID userId) {

        Portfolio portfolio = Portfolio.builder()
                .userId(userId)
                .name(portfolioRequest.getName())
                .type(portfolioRequest.getName())
                .currency(portfolioRequest.getCurrency())
                .totalValue(portfolioRequest.getTotalValue())
                .cashBalance(portfolioRequest.getCashBalance())
                .riskProfile(portfolioRequest.getRiskProfile())
                .strategy(portfolioRequest.getStrategy())
                .advisor(portfolioRequest.getAdvisor())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();


        return portfolioRepo.save(portfolio);
    }
}
