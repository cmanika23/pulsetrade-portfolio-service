package com.pulsetrade.portfolio_service.domain.repository;

import com.pulsetrade.portfolio_service.domain.model.Portfolio;

import java.util.List;
import java.util.UUID;

public interface IPortfolioRepository {
    List<Portfolio> findByUserId(UUID userId);
    Portfolio save(Portfolio portfolio);
    Portfolio findByPortfolioId(Long id);
}
