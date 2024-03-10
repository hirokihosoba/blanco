DROP DATABASE IF EXISTS blanco;
CREATE DATABASE blanco;
USE blanco;
DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CUSTOMER
(
  customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(256) NOT NULL,
  password VARCHAR(32) NOT NULL
) DEFAULT CHARACTER SET utf8mb4;

INSERT INTO CUSTOMER
    (name, password)
VALUES
    ('suzuki', 'kota'),
    ('abe', 'shinzo'),
    ('otani', 'syohei');
