package com.pulsetrade.portfolio_service.domain.repository;

import com.pulsetrade.portfolio_service.domain.model.Holding;

import java.util.List;

public interface IHoldingRepository {
    List<Holding> findByPortfolioId(Long portfolioId);
    Holding save(Holding holding);
    Holding findById(Long id);
    boolean existsById(Long id);
    void deleteById(Long id);
}
