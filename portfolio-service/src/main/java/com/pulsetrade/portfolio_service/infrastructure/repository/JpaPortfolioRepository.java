package com.pulsetrade.portfolio_service.infrastructure.repository;

import com.pulsetrade.portfolio_service.domain.model.Portfolio;
import com.pulsetrade.portfolio_service.domain.repository.IPortfolioRepository;
import com.pulsetrade.portfolio_service.infrastructure.entity.PortfolioEntity;
import com.pulsetrade.portfolio_service.infrastructure.mapper.PortfolioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class JpaPortfolioRepository implements IPortfolioRepository {

    private final SpringPortfolioJpaRepository springRepo;
    private final PortfolioMapper mapper;

    @Override
    public List<Portfolio> findByUserId(UUID userId) {
        return springRepo.findByUserId(userId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Portfolio save(Portfolio portfolio) {
        var entity = mapper.toEntity(portfolio);
        return mapper.toDomain(springRepo.save(entity));
    }

    @Override
    public Portfolio findByPortfolioId(Long id) {
        Optional<PortfolioEntity> portfolio = springRepo.findById(id);
        assert portfolio.orElse(null) != null;
        return mapper.toDomain(portfolio.orElse(null));
    }
}
