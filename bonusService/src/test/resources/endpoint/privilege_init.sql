CREATE TABLE IF NOT EXISTS privilege
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(80) NOT NULL UNIQUE,
    status   VARCHAR(80) NOT NULL DEFAULT 'BRONZE'
        CHECK (status IN ('BRONZE', 'SILVER', 'GOLD')),
    balance  INT
);

CREATE TABLE IF NOT EXISTS privilege_history
(
    id             SERIAL PRIMARY KEY,
    privilege_id   INT REFERENCES privilege (id),
    ticket_uid     uuid        NOT NULL,
    datetime       TIMESTAMP   NOT NULL,
    balance_diff   INT         NOT NULL,
    operation_type VARCHAR(20) NOT NULL
        CHECK (operation_type IN ('FILL_IN_BALANCE', 'DEBIT_THE_ACCOUNT'))
);

INSERT INTO privilege (username, status, balance) VALUES ('Roman', 'GOLD', 500);
INSERT INTO privilege_history(privilege_id, ticket_uid, datetime, balance_diff, operation_type)
    VALUES(1, 'd6818ec1-3d27-4a14-b660-1922b14c515d', '2022-11-18 12.00.00', 1500, 'DEBIT_THE_ACCOUNT'),
    (1, '6c10f0e9-170c-4d69-bc8b-56f303e59a10', '2022-11-18 12.30.00', 200, 'FILL_IN_BALANCE');