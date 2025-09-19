package hello.hello_spring.controller;
//import ch.qos.logback.core.model.Model;
import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;
import org.springframework.ui.Model;
//스프링 컨트롤러에서 컨트롤 빈이 관리된다.
//객체가 만들어져서 Spring Container가 관리함

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
//        ViewResolver가 template에서 createMemberForm 찾는다.
    }

// 데이터를 폼 같은 것에 넣어서 전달할 때 사용 (Get은 조회할 때 사용)
    @PostMapping("/members/new")
    public String create(MemberForm form) {
//        Memberform의 name에 form 값이 넣어짐. 그래서 밑에 getName으로 꺼냄(public이라서 가능)
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);  // join은 회원가입할 때 배움
        return "redirect:/";  // 회원가입 끝나면 홈으로
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
//      findMembers()로 멤버들 다 끄집어 올 수 있다.
        model.addAttribute("members", members);
        return "members/memberList";
    }
}