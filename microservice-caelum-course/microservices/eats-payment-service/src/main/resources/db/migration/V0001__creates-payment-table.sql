CREATE TABLE IF NOT EXISTS payment (
  id bigint NOT NULL PRIMARY KEY,
  value decimal(19,2) NOT NULL,
  name varchar(100) DEFAULT NULL,
  number varchar(19) DEFAULT NULL,
  expiration varchar(7) NOT NULL,
  code varchar(3) DEFAULT NULL,
  status varchar(255) NOT NULL,
  payment_form_id bigint NOT NULL,
  order_id bigint NOT NULL
);

CREATE INDEX IF NOT EXISTS order_id_idx ON payment(order_id);
CREATE INDEX IF NOT EXISTS payment_form_idx ON payment(payment_form_id);