package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;


public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
// 스프링데이터JPA가 구현체를 자동으로 만들어줌(스프링 빈 자동으로 등록)
    Optional<Member> findByName(String name);
}
