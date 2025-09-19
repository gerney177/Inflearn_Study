package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("taegeon");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
//      System.out.println("result = " + (result == member));
//        위 사용말고 아래 거 사용하자. 텍스트로 볼수만은 없으니
        Assertions.assertEquals(member, result);
//        Equal이면, 실행 창에 녹색v 표시
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("taegeon");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("taegyeong");
        repository.save(member2);

        Member result = repository.findByName("taegeon").get();
        Assertions.assertEquals(member1, result);
    }

    @Test
    public void findByAll() {
        Member member1 = new Member();
        member1.setName("taegeon");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("taegyeong");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(2, result.size());
    }
}
