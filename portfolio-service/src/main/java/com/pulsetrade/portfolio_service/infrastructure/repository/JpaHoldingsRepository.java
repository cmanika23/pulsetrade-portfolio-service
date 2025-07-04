package com.pulsetrade.portfolio_service.infrastructure.repository;

import com.pulsetrade.portfolio_service.domain.model.Holding;
import com.pulsetrade.portfolio_service.domain.repository.IHoldingRepository;
import com.pulsetrade.portfolio_service.infrastructure.entity.HoldingEntity;
import com.pulsetrade.portfolio_service.infrastructure.mapper.HoldingsMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaHoldingsRepository implements IHoldingRepository {

    private SpringHoldingsJpaRepository springRepo;
    private HoldingsMapper mapper;

    @Override
    public List<Holding> findByPortfolioId(Long portfolioId) {
        return springRepo.findByPortfolioId(portfolioId)
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Holding save(Holding holding) {
        HoldingEntity entity = mapper.toEntity(holding);
        return mapper.toDomain(springRepo.save(entity));
    }

    @Override
    public Holding findById(Long id) {
        return springRepo.findById(id)
                .map(mapper::toDomain)
                .orElseThrow(() -> new EntityNotFoundException("Holding not found with ID: " + id));

    }

    @Override
    public boolean existsById(Long id) {
        return springRepo.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        springRepo.deleteById(id);
    }
}
