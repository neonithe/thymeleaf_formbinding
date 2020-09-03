package se.lexicon.mattias.thymeleaf_formbinding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import se.lexicon.mattias.thymeleaf_formbinding.entity.Customer;
import se.lexicon.mattias.thymeleaf_formbinding.entity.CustomerDetails;
import se.lexicon.mattias.thymeleaf_formbinding.service.CustomerDAO;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerDAO dao;

    @PostConstruct
    public void init() {

        /** Create dummy data to database **/

        dao.save(new Customer("Mattias","ma@no.com",new CustomerDetails("street1","333331","city1","1234567891","1234567810")));
        dao.save(new Customer("Sofia",  "so@no.com",new CustomerDetails("street2","333332","city2","1234567892","1234567820")));
        dao.save(new Customer("Linn",   "li@no.com",new CustomerDetails("street3","333333","city3","1234567893","1234567830")));
        dao.save(new Customer("Martin", "mr@no.com",new CustomerDetails("street4","333334","city4","1234567894","1234567840")));
        dao.save(new Customer("Kenny",  "ke@no.com",new CustomerDetails("street5","333335","city5","1234567895","1234567850")));
        dao.save(new Customer("Ewa",    "ew@no.com",new CustomerDetails("street6","333336","city6","1234567896","1234567860")));
        dao.save(new Customer("Birger", "bi@no.com",new CustomerDetails("street7","333337","city7","1234567897","1234567870")));

    }

}
