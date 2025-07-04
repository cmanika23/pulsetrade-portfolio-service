package com.pulsetrade.portfolio_service.infrastructure.repository;

import com.pulsetrade.portfolio_service.infrastructure.entity.PortfolioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SpringPortfolioJpaRepository extends JpaRepository<PortfolioEntity, Long> {
    List<PortfolioEntity> findByUserId(UUID userId);

}
