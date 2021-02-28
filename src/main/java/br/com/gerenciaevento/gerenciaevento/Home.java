package br.com.gerenciaevento.gerenciaevento;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class Home {

    @GetMapping("")
    public String showSignUpForm(Home home){
        return "index-home";
    }

}
