package com.pulsetrade.portfolio_service.api.controller;

import com.pulsetrade.portfolio_service.application.service.PortfolioService;
import com.pulsetrade.portfolio_service.domain.model.Portfolio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/portfolios")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("")
    public ResponseEntity<List<Portfolio>> getPortfolios(Authentication auth){
        UUID userId = (UUID) auth.getPrincipal();
        List<Portfolio> portfolios = portfolioService.getPortfoliosByUserId(userId);
        return ResponseEntity.ok(portfolios);
    }

    @PostMapping
    public ResponseEntity<Portfolio> createPortfolio(@RequestBody Portfolio portfolio, Authentication auth){
        UUID userId = (UUID) auth.getPrincipal();
        portfolio.setUserId(userId);
        Portfolio portfolioSaved = portfolioService.createPortfolio(portfolio);
        return ResponseEntity.ok(portfolioSaved);
    }

}
