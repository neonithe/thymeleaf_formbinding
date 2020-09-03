package se.lexicon.mattias.thymeleaf_formbinding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lexicon.mattias.thymeleaf_formbinding.entity.Customer;
import se.lexicon.mattias.thymeleaf_formbinding.entity.CustomerDetails;
import se.lexicon.mattias.thymeleaf_formbinding.service.CustomerDAO;

import javax.annotation.PostConstruct;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index.html";
    }

}
