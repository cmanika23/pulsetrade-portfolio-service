package com.pulsetrade.portfolio_service.application.service;

import com.pulsetrade.portfolio_service.api.dto.PortfolioRequest;
import com.pulsetrade.portfolio_service.api.dto.PortfolioResponse;
import com.pulsetrade.portfolio_service.domain.model.Portfolio;

import java.util.List;
import java.util.UUID;

public interface PortfolioService {
    public List<PortfolioResponse> getPortfoliosByUserId(UUID userID);
    public Portfolio createPortfolio(PortfolioRequest portfoliorequest, UUID userId);
}
