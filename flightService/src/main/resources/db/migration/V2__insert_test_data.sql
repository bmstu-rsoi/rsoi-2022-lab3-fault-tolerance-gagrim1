INSERT INTO airport (id, name, city, country)
    VALUES (1, 'Шереметьево', 'Москва', 'Россия'),
    (2, 'Пулково', 'Санкт-Петербург', 'Россия');

INSERT INTO flight (flight_number, datetime, from_airport_id, to_airport_id, price)
    VALUES ('AFL031', '2021-10-08 20:00', 1, 2, 1500);