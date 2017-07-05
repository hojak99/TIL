-- USERS 테이블 생성
CREATE TABLE users (
  id VARCHAR(10) PRIMARY KEY,
  name varchar(20) NOT NULL,
  password VARCHAR(20) NOT NULL
);

SELECT * FROM USERS;

-- users 테이블에서 'whiteship' 이란 id 를 가진 데이터를 삭제
DELETE FROM users WHERE id = 'whiteship';