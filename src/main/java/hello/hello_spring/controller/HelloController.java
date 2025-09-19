package hello.hello_spring.controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
//    GetMapping으로 hello url에 매칭이 됨.
    public String hello(Model model) {
        model.addAttribute("data", "taegeon");
        return "hello";
//        return으로 (리소스에 템플렛에 있는 hello.html) 연결. viewResolver가 화면을 찾아서 처리함.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    // API 활용. html 코드 하나도 없음. 밑의 데이터를 그대로 올려줌.
    @GetMapping("hello-spring")
    @ResponseBody
    public String helloSpring(@RequestParam("name") String name) {
        return "hello " + name;
    }

// json으로 나옴
    @GetMapping("hello-api")
    @ResponseBody
//    얘가 있으면 HTTP응답에 그냥 그대로 이 데이터를 넣은 게 됨 > HTTPMessageConverter가 동작(ViewResolver 대신), 단순 문자면 StringConverter가 동작
//    그러나 밑이 객체이므로 JsonConverter가 동작
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

}
