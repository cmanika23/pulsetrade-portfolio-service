package com.pulsetrade.portfolio_service.application.service;

import com.pulsetrade.portfolio_service.domain.model.Portfolio;

import java.util.List;
import java.util.UUID;

public interface PortfolioService {
    public List<Portfolio> getPortfoliosByUserId(UUID userID);
    public Portfolio createPortfolio(Portfolio portfolio);
}
