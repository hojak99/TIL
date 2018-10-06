# Spring Boot JPA MultiSource Transaction

Spring boot : 2.0.5 버전을 사용 중이다.

Spring boot 에서 JPA 를 사용할 때 2개 이상의 DB 를 사용할 때가 있다. 그럴 때 이제 트랜잭션 문제가 생길 수 있는데, Spring boot 에서 제공하는 `@Transaction` 어노테이션에 대한 주석을 살펴보면 다음과 같이 주석이 달려있다.

```
/**
	 * A <em>qualifier</em> value for the specified transaction.
	 * <p>May be used to determine the target transaction manager,
	 * matching the qualifier value (or the bean name) of a specific
	 * {@link org.springframework.transaction.PlatformTransactionManager}
	 * bean definition.
	 * @since 4.2
	 * @see #value
	 */
	@AliasFor("value")
	String transactionManager() default "";
```

그렇다면 `@Transactional(value = "testTransactionManager")` 와 같이 특정 DB 에 대한 transaction 을 각각 사용할 수 있게 되는 것 같다.

우선 필자는 `Hikari` 를 사용을 했다.

---

먼저 application.yml 에서 db 설정을 해주도록 하겠다. 물론, 코드로 작성해도 되는데 yml 에서 하는게 더 편하다고 생각한다.

프로젝트에서 사용할 DB 는 각각 `school` 라는 DB 와 `company` 라는 DB 이다.

```
spring:
  datasource:
    hikari:
      school:
        jdbc-url: jdbc:mysql://~~~
        character_set_server=utf8mb4&allowMultiQueries=true&useSSL=false
        username: ~~~
        password: ~~~
        driver-class-name: com.mysql.jdbc.Driver
      company:
        jdbc-url: jdbc:mysql://~~~
        characterEncoding=utf8&allowMultiQueries=true&useSSL=false
        username: ~~~
        password: ~~~
        driver-class-name: com.mysql.jdbc.Driver
```


먼저 DB 설정을 각각 해줘야 하는데 공통되는 Configuration 부분은 따로 클래스로 빼놓았다. 여기서 메인으로 사용할 DB 를 `school`로 지정해놓기 위해 추가적으로 `@Primary` 어노테이션을 달아주었다. 그렇게 된다면 `@Transactional` 만 사용했을 때는 `school` db를, `company` db에 트랜잭션을 걸어줄 때는 `@Transactional` 에 value 값을 달아주면 된다.

만약 `@Primary` 를 달아주지 않는 다면 `@Transactional` 어노테이션에 모두 `value` 값을 넣어줘야 한다. 그렇지 않으면 어떤 db 에 트랜잭션 걸지 모르기 때문이다.

```
@Configuration
@EnableConfigurationProperties
public class DataSourceProperties {

    @Bean(name = "schoolDataSource")
    @Qualifier("schoolDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.hikari.school")
    public DataSource schoolDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean(name = "companyDataSource")
    @Qualifier("companyDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari.company")
    public DataSource companyDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}

```

이렇게 우선 `DataSourceProperties` 라는 Configuration 클래스를 하나 만들어 놓았으니 이제 각각의 db 를 셋팅하는 클래스를 만들어주면 된다.

---

우선 `company` db 의 설정 클래스를 먼저 살펴보겠다. 여기서 가장 중요한 부분은 Bean 으로 등록한 `PlatfromTransactionManager` 를 return 해주는 `companyTransactionManager(EntityManagerFactoryBuilder builder)` 메소드다.

```
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "companyEntityManagerFactory",
        transactionManagerRef = "companyTransactionManager",
        basePackages = "(해당 company 에 대한 repository 패키지)"
)
public class CompanyRepositoryConfig {

    @Autowired
    @Qualifier("companyDataSource")     // 아까 @Bean 으로 등록했던 것을 가져오도록 한다.
    private DataSource companyDataSource;

    @Bean(name = "companyEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean companyEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(companyDataSource)
                .packages("(해당 company에 대한 domain 패키지)")
                .persistenceUnit("company")
                .build();
    }

    // 가장 중요한 부분.
    @Bean("companyTransactionManager")
    public PlatformTransactionManager companyTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(companyEntityManagerFactory(builder).getObject());
    }

}

```

이제 `CompanyRepositoryConfig` 클래스처럼 `SchoolRepositoryConfig` 클래스를 생성해주면 된다. base package 나 @Qualifier 를 school 에 맞게 변경해주면 된다.

그리고 이제 `Service` 클래스에서 `SchoolRepository` interface 를 이용해 어떠한 데이터를 가져오는 클래스에서 Transaction 을 걸어주는 코드이다.

```
// 자동으로 school db 를 바라본다.
@Transactional
public Page<School> findAllSchool(Pageable pageable) {
    Page<School> schoolList = schoolRepository.findAll(pageable)
    
    log.info("[SchoolService.findAllSchool] : {}", schoolList);
    return schoolList;
}
```

```
@Transactional(value="companyTransactionManager")
public Page<Company> findAllCompany(Pageable pageable) {
    Page<Company> companyList = companyRepository.findAll(pageable)
    
    log.info("[CompanyService.findAllCompany] : {}", companyList);
    return companyList;
}
```

이제 transaction 이 각각에 db 맞게 돌 것이다.
이제 검증을 해보면 되는데, 아마 bean 등록만 되면 잘 적용이 된 것으로 보면 될 것 같다.

그래도 코드로 검증을 해보고 싶어서 유닛 테스트 코드를 작성해보았었는데 이 부분은 알아서 해보자. save 하는 테스트 메소드를 만들어서 테스트를 했었는데 필자는 롤백이 잘 됐었다.