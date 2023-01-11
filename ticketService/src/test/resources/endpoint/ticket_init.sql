CREATE TABLE IF NOT EXISTS tickets(
  id            SERIAL PRIMARY KEY,
  ticket_uid    uuid UNIQUE NOT NULL,
  username      VARCHAR(80) NOT NULL,
  flight_number VARCHAR(20) NOT NULL,
  price         INT         NOT NULL,
  status        VARCHAR(20) NOT NULL
      CHECK (status IN ('PAID', 'CANCELED'))
);

INSERT INTO tickets (ticket_uid, username, flight_number, price, status)
  VALUES ('d6818ec1-3d27-4a14-b660-1922b14c515d', 'Roman', 'AFL031', 1500, 'PAID'),
  ('6c10f0e9-170c-4d69-bc8b-56f303e59a10', 'Roman', 'AFL040', 1500, 'PAID'),
  ('8d456c13-a60a-4d34-9db2-3965078c4045', 'Yuri', 'AFL031', 1500, 'PAID');
