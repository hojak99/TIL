# 현재 존재하는 데이터베이스 리스트 출력
show databases;

# "world" 데이터베이스 사용
use world;

# "world" DB의 테이블 리스트 출력
show tables;

# "world" DB의 "city" 테이블 구조 출력
desc city;

# "world" DB의 "city" 테이블의 모든 컬럼 출력 
select * from city;

# "world" DB의 "city" 테이블에서 CountryCode 가 "KOR" 인 나라의 이름을 출력
select Name from city where CountryCode='KOR';

# "world" DB의 "city" 테이블에서 Population 이 "5,000,000" 인 나라의 이름을 출력
select Name from city where Population > 5000000;

# 각각의 필드와 대응 시켜줘서 insert 를 시켜주어야 한다.
insert into city (ID, Name, CountryCode, District, Population) values (10000, "Sample", "KOR", "Test", 1000000);

# 이 경우에는 모든 컬럼 값들이 일일히 필드와 대응되면 생략 가능
insert into city values (20000, "SampleTest", "KOR", "Test", 2000000);

# ID 가 100000 인 레코드 출력
select * from city where ID = 10000;

# ID 가 200000 인 레코드 출력
select * from city where ID = 20000;

# ID 가 10000 인 레코드의 name 을 "SampleRevised" 로 변경
update city set name = "SampleRevised" where id = 10000;

# ID 가 20000 이며 Population 이 2000000 인 레코드를 삭제
delete from city where (ID = 20000) AND (Population = 2000000);

# ID 가 10000 이며 Population 이 1000000 인 레코드를 삭제
delete from city where (ID = 10000) AND (Population = 1000000);

