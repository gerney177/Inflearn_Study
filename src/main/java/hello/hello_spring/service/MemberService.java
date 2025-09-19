package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import java.util.*;
@Transactional
// command+shift+t 하면 테스트 간단 생성
public class MemberService {
    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


//    회원 가입
    public Long join(Member member) {
//        같은 이름은 불가
        validateDuplicateMember(member); // 중복 회원 검증
//        command+option+v : 짱 좋다.
        memberRepository.save(member);
        return member.getId();
    }
//  메서드 추출함
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) //findByName의 결과는 Optional 멤버이므로, ifPresent함수 사용 가능
                        .ifPresent(m -> {
                            throw new IllegalStateException("이미 존재하는 회원입니다. ");
                        });
    }

//   전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

//
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
