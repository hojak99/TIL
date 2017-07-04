-- USERS 테이블 생성
CREATE TABLE users (
  id VARCHAR(10) PRIMARY KEY,
  name varchar(20) NOT NULL,
  password VARCHAR(20) NOT NULL
);

SELECT * FROM USERS;