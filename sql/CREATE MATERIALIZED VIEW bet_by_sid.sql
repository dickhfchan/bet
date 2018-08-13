DROP MATERIALIZED VIEW multimatrix.bet_by_sid;

CREATE MATERIALIZED VIEW multimatrix.bet_by_sid AS
    SELECT *
    FROM multimatrix.bet_by_market
    WHERE account_id IS NOT NULL AND status IS NOT NULL AND state IS NOT NULL AND market_id IS NOT NULL AND bet_id IS NOT NULL AND selection_id IS NOT NULL AND event_type_id IS NOT NULL AND placed_date IS NOT NULL AND side IS NOT NULL AND event_id IS NOT NULL AND settled_date IS NOT NULL
    PRIMARY KEY (selection_id, market_id, event_type_id, event_id, bet_id, account_id, state, side, status, placed_date);
