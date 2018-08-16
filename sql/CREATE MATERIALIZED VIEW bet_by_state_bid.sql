DROP MATERIALIZED VIEW multimatrix.bet_by_state_bid;

CREATE MATERIALIZED VIEW multimatrix.bet_by_state_bid AS
    SELECT *
    FROM multimatrix.bet_by_market
    WHERE account_id IS NOT NULL AND status IS NOT NULL AND state IS NOT NULL AND market_id IS NOT NULL AND bet_id IS NOT NULL AND selection_id IS NOT NULL AND event_type_id IS NOT NULL AND placed_date IS NOT NULL AND side IS NOT NULL AND event_id IS NOT NULL AND settled_date IS NOT NULL
    PRIMARY KEY ((state, bet_id), account_id, status, settled_date, market_id, placed_date, selection_id, event_type_id, side, event_id);
