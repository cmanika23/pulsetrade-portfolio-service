package com.pulsetrade.portfolio_service.application.service;

import com.pulsetrade.portfolio_service.api.dto.HoldingsRequest;
import com.pulsetrade.portfolio_service.api.dto.HoldingsResponse;
import com.pulsetrade.portfolio_service.domain.model.Holding;
import com.pulsetrade.portfolio_service.domain.model.Portfolio;
import com.pulsetrade.portfolio_service.domain.repository.IHoldingRepository;
import com.pulsetrade.portfolio_service.domain.repository.IPortfolioRepository;
import com.pulsetrade.portfolio_service.infrastructure.mapper.HoldingsMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class HoldingsServiceImpl implements HoldingsService{


    private final IPortfolioRepository portfolioRepo;
    private final IHoldingRepository holdingRepo;
    private final HoldingsMapper holdingsMapper;


    @Override
    public List<HoldingsResponse> getHoldingsByPortfolioId(Long id) {
        List<Holding> holdings = holdingRepo.findByPortfolioId(id);

        return holdings
                .stream()
                .map(holdingsMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public HoldingsResponse getHoldingById(Long holdingId) {
        Holding holding= holdingRepo.findById(holdingId);

        return holdingsMapper.toResponse(holding);
    }

    @Override
    public HoldingsResponse addHolding(Long portfolioId, HoldingsRequest request) {

        Portfolio portfolio = portfolioRepo.findByPortfolioId(portfolioId);

        Holding holding = holdingsMapper.toDomain(request);
        holding.setPortfolio(portfolio);

        BigDecimal marketValue = holding.getCurrentPrice().multiply(BigDecimal.valueOf(holding.getQuantity()));
        BigDecimal costBasis = holding.getAverageBuyPrice().multiply(BigDecimal.valueOf(holding.getQuantity()));

        holding.setMarketValue(marketValue);
        holding.setGainLoss(marketValue.subtract(costBasis));

        return holdingsMapper.toResponse(holdingRepo.save(holding));
    }

    @Override
    public HoldingsResponse updateHolding(Long holdingId, HoldingsRequest request) {

        Holding existing = holdingRepo.findById(holdingId);
        if(request.getSymbol()!=null && !"".equalsIgnoreCase(request.getSymbol()))
            existing.setSymbol(request.getSymbol());

        if(request.getName()!=null && !"".equalsIgnoreCase(request.getName()))
            existing.setName(request.getName());

        if(request.getExchange()!=null && !"".equalsIgnoreCase(request.getExchange()))
            existing.setExchange(request.getExchange());

        if(request.getQuantity()!=null)
            existing.setQuantity(request.getQuantity());

        if(request.getAverageBuyPrice()!=null)
            existing.setAverageBuyPrice(request.getAverageBuyPrice());

        if(request.getCurrentPrice()!=null)
            existing.setCurrentPrice(request.getCurrentPrice());

        if(request.getSector()!=null && !"".equalsIgnoreCase(request.getSector()))
            existing.setSector(request.getSector());

        if(request.getAssetType()!=null && !"".equalsIgnoreCase(request.getAssetType()))
            existing.setAssetType(request.getAssetType());

        if(request.getPurchaseDate()!=null)
            existing.setPurchaseDate(request.getPurchaseDate());

        if(request.getDividendReinvestment()!=null)
            existing.setDividendReinvestment(request.getDividendReinvestment());

        if(request.getNotes()!=null && !"".equalsIgnoreCase(request.getNotes()))
            existing.setNotes(request.getNotes());

        BigDecimal marketValue = existing.getCurrentPrice().multiply(BigDecimal.valueOf(existing.getQuantity()));
        BigDecimal costBasis = existing.getAverageBuyPrice().multiply(BigDecimal.valueOf(existing.getQuantity()));

        existing.setMarketValue(marketValue);
        existing.setGainLoss(marketValue.subtract(costBasis));

        return holdingsMapper.toResponse(holdingRepo.save(existing));
    }

    @Override
    public void deleteHolding(Long holdingId) {
        if(!holdingRepo.existsById(holdingId)){
            throw new IllegalArgumentException("Holding not found");
        }
        holdingRepo.deleteById(holdingId);
    }
}
