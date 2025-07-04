package com.pulsetrade.portfolio_service.infrastructure.repository;

import com.pulsetrade.portfolio_service.infrastructure.entity.HoldingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringHoldingsJpaRepository extends JpaRepository<HoldingEntity, Long> {
    List<HoldingEntity> findByPortfolioId(Long id);
}
