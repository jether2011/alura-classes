CREATE SEQUENCE IF NOT EXISTS payment_id_seq
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1
 CACHE 1;
 
CREATE TABLE IF NOT EXISTS payment (
  id bigint NOT NULL PRIMARY KEY DEFAULT nextval('payment_id_seq'),
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