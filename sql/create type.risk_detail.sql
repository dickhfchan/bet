CREATE TYPE multimatrix.risk_detail (
    account_id bigint,
    value decimal,
    type text //super master, master, sub
);