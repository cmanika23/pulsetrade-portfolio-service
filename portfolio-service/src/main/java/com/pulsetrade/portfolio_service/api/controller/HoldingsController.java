package com.pulsetrade.portfolio_service.api.controller;

import com.pulsetrade.portfolio_service.api.dto.HoldingsRequest;
import com.pulsetrade.portfolio_service.api.dto.HoldingsResponse;
import com.pulsetrade.portfolio_service.application.service.HoldingsService;
import com.pulsetrade.portfolio_service.domain.model.Holding;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class HoldingsController {

    private final HoldingsService holdingService;

    /**
     * GET    /api/portfolios/{portfolioId}/holdings
     * POST   /api/portfolios/{portfolioId}/holdings
     * GET    /api/holdings/{holdingId}
     * PUT    /api/holdings/{holdingId}
     * DELETE /api/holdings/{holdingId}
     */


    @GetMapping("portfolios/{portfolioId}/holdings")
    public ResponseEntity<List<HoldingsResponse>> getHoldingsByPortfolioId(@PathVariable Long portfolioId){
        List<HoldingsResponse> holdings = holdingService.getHoldingsByPortfolioId(portfolioId);
        return ResponseEntity.ok(holdings);
    }

    @PostMapping("portfolios/{portfolioId}/holdings")
    public ResponseEntity<HoldingsResponse> addHoldingToPortfolio(@PathVariable Long portfolioId, @RequestBody HoldingsRequest holding){
        HoldingsResponse res = holdingService.addHolding(portfolioId, holding);
        return ResponseEntity.ok(res);
    }

    @GetMapping("holdings/{holdingId}")
    public ResponseEntity<HoldingsResponse> getHoldingByHoldingId(@PathVariable Long holdingId){
        HoldingsResponse res = holdingService.getHoldingById(holdingId);
        return ResponseEntity.ok(res);
    }

    @PutMapping("holdings/{holdingId}")
    public ResponseEntity<HoldingsResponse> updateHolding(@PathVariable Long holdingId, @RequestBody HoldingsRequest holding){
        HoldingsResponse res = holdingService.updateHolding(holdingId, holding);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping("holdings/{holdingId}")
    public ResponseEntity<Void> deleteHolding(@PathVariable Long holdingId){
        holdingService.deleteHolding(holdingId);
        return ResponseEntity.noContent().build();
    }

}
