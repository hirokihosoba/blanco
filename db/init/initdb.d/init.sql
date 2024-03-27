DROP DATABASE IF EXISTS blanco;
CREATE DATABASE blanco;
USE blanco;
DROP TABLE IF EXISTS CUSTOMER;

CREATE TABLE CUSTOMER
(
  customer_id VARCHAR(256) NOT NULL PRIMARY KEY,
  display_name VARCHAR(256) NOT NULL,
  password VARCHAR(32) NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) DEFAULT CHARACTER SET utf8mb4;

INSERT INTO CUSTOMER
    (customer_id, display_name, password)
VALUES
    ('suzuki', '鈴木', 'kota'),
    ('abe', '安倍', 'shinzo'),
    ('otani', '大谷', 'syohei');
