package com.pulsetrade.portfolio_service.application.service;

import com.pulsetrade.portfolio_service.api.dto.HoldingsRequest;
import com.pulsetrade.portfolio_service.api.dto.HoldingsResponse;


import java.util.List;


public interface HoldingsService {

    List<HoldingsResponse> getHoldingsByPortfolioId(Long id);
    HoldingsResponse getHoldingById(Long holdingId);
    HoldingsResponse addHolding(Long portfolioId, HoldingsRequest request);
    HoldingsResponse updateHolding(Long holdingId, HoldingsRequest request);
    void deleteHolding(Long holdingId);

}
