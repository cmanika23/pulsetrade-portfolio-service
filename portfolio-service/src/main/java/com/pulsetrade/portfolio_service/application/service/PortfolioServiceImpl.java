package com.pulsetrade.portfolio_service.application.service;

import com.pulsetrade.portfolio_service.domain.model.Portfolio;
import com.pulsetrade.portfolio_service.domain.repository.IPortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PortfolioServiceImpl implements PortfolioService{

    private final IPortfolioRepository portfolioRepo;

    @Override
    public List<Portfolio> getPortfoliosByUserId(UUID userID) {
        return portfolioRepo.findByUserId(userID);
    }

    @Override
    public Portfolio createPortfolio(Portfolio portfolio) {
        portfolio.setCreatedAt(LocalDateTime.now());
        portfolio.setUpdatedAt(LocalDateTime.now());
        return portfolioRepo.save(portfolio);
    }
}
