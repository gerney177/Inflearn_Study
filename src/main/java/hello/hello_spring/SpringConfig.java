package hello.hello_spring;

import hello.hello_spring.aop.TimeTraceApp;
import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

/* 메모리 사용 시.
스프링이 자체적으로 빈 설정할 떄, 데이터소스 만들어 줌.
    private final DataSource dataSource;
    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

/* JPA 사용 시.
    private EntityManager em;
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository(); > 메모리 사용
//        return new JdbcMemberRepository(dataSource); > JDBC 사용
//        return new JdbcTemplateMemberRepository(dataSource); > JdbcTemplate 사용
//        return new JPAMemberRepository(em); > JPA 사용
//    여기서 스프링 데이터 JPA는 구현 클래스를 작성할 필요X, 인터페이스만으로 개발 끝

//    }
//    바꿔기는 것이 매우 편리 > 스프링 컨테이너가 지원
//    개방-폐쇄 원칙(OCP) : 확장에는 열려있고, 수정(변경)에는 닫혀있다.

//    Jdbc > JdbcTemplate(반복문 없앰) > JPA(SQL 쿼리도 자동으로 처리)
//    JPA 사용 시, SQL과 데이터 중심의 설게에서 -> 객체 중심의 설계로 패러다임 전환 가능.
//    HOW? > 애플리케이션 실행 시, 스프링 데이터 JPA가 자동으로 구현체 생성
}
