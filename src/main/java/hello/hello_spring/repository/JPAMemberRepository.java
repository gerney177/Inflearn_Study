package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import jakarta.persistence.EntityManager;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JPAMemberRepository implements MemberRepository {

//  JPA를 쓰려면 EntityManager를 주입받아야 한다.
    private final EntityManager em;

    public JPAMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name",  Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }
// JPQL로 작성해야 함 > 근데 이것도 안해도 되는 기술이 있음

    @Override
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
