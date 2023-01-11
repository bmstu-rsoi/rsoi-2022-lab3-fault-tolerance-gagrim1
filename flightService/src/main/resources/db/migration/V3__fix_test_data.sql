TRUNCATE TABLE flight RESTART IDENTITY;

INSERT INTO flight (flight_number, datetime, from_airport_id, to_airport_id, price)
    VALUES ('AFL031', '2021-10-08 20:00', 2, 1, 1500);