DROP MATERIALIZED VIEW bet_by_bet_id;

CREATE MATERIALIZED VIEW bet_by_bet_id AS
       SELECT * FROM bet_by_market
       WHERE account_id IS NOT NULL AND status IS NOT NULL AND state IS NOT NULL AND market_id IS NOT NULL AND bet_id IS NOT NULL AND selection_id IS NOT NULL AND event_type_id IS NOT NULL AND placed_date IS NOT NULL AND side IS NOT NULL AND event_id IS NOT NULL
       PRIMARY KEY ((bet_id),market_id, event_type_id, event_id, selection_id, account_id, state, side, status, placed_date);