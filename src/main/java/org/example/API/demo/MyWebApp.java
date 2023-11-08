package org.example.API.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class MyWebApp {

    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/Presentation")
    public String Presentation() {
        return "terrainrouge/presentation";
    }

    @GetMapping("/LogIN")
    public String LogIN() {
        return "terrainrouge/login";
    }

    @GetMapping("/CreateAccount")
    public String CreateAccount() {
        return "terrainrouge/createacount";
    }

    @GetMapping("/Loading")
    public String Loading() {
        return "terrainrouge/loading";
    }

    @GetMapping("/Accueil")
    public String Accueil() {
        return "terrainrouge/accueil";
    }

    @GetMapping("/Profil")
    public String Profil() {
        return "terrainrouge/profil";
    }

    @GetMapping("/Evenement")
    public String Evenement() {
        return "terrainrouge/evenement";
    }


    public static void main(String[] args) {
        SpringApplication.run(MyWebApp.class, args);
    }
}
