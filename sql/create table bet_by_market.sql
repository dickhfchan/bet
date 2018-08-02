CREATE TABLE bet_by_market(
   event_type_id bigint,
   event_id bigint,
   market_id text,
   selection_id bigint,
   bet_id bigint,
   account_id bigint,

   state text, //match, unmatch
   side text, //back, lay
   price decimal, //odd
   handicap decimal,
   absolute_ex_rate decimal,
   persistence_type text, //LAPSE, PERSIST, MARKET_ON_CLOSE
   status text,
   placed_ip text,

   size decimal, //price
   size_placed decimal,
   size_matched decimal,
   size_cancelled decimal,
   size_remaining decimal,
   size_lapsed decimal,
   size_voided decimal,
   average_size_matched decimal,

   placed_date timestamp,
   matched_date timestamp,
   cancelled_date timestamp,
   settled_date timestamp,
   
   risk_coefficient map<bigint, decimal>,
   risk_detail risk_detail,

   PRIMARY KEY (market_id, event_type_id, event_id, selection_id, bet_id, account_id, state, side, status, placed_date)
);