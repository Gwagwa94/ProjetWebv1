package org.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class WebApp {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/page")
    public String testPage() {
        return "pages/testpage";
    }

    @GetMapping("/image/1")
    public String testImage1() {
        return "pages/image1";
    }

    @GetMapping("/definition")
    public String definition() {
        return "pages/definition";
    }

    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }
}