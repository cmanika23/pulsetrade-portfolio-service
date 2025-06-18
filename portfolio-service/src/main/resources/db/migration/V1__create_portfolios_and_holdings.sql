-- V1__create_portfolios_and_holdings.sql

CREATE TABLE portfolios (
    id BIGSERIAL PRIMARY KEY,
    user_id UUID NOT NULL,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    currency VARCHAR(255) NOT NULL,
    total_value NUMERIC DEFAULT 0,
    cash_balance NUMERIC DEFAULT 0,
    risk_profile VARCHAR(255),
    strategy VARCHAR(255),
    advisor VARCHAR(255),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE holdings (
    id BIGSERIAL PRIMARY KEY,
    portfolio_id BIGINT NOT NULL,
    symbol VARCHAR(10) NOT NULL,
    name VARCHAR(255),
    exchange VARCHAR(255),
    quantity INTEGER NOT NULL,

    average_buy_price NUMERIC,
    current_price NUMERIC,
    market_value NUMERIC,
    gain_loss NUMERIC,
    weight NUMERIC,

    sector VARCHAR(100),
    asset_type VARCHAR(50),
    purchase_date TIMESTAMP,
    dividend_reinvestment BOOLEAN,
    notes TEXT,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT fk_holdings_portfolio
            FOREIGN KEY (portfolio_id)
            REFERENCES portfolios(id)
            ON DELETE CASCADE
);
