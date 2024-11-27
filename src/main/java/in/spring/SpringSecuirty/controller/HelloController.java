package in.spring.SpringSecuirty.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String getHello(){
        System.out.println("Hello success");
        return "hello";
    }
}
