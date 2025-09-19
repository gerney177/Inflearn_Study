package hello.hello_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // /는 로컬호스트8080으로 들어오면 GetMapping이 호출됨 > 그 후 home.html(String home)이 호출
    public String home() {
        return "home";
    }
}
// 정적 컨텐츠보다 우선순위가 높아서 HelloController는 무시되고 HomeController가 출력.