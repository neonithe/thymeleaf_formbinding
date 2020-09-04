package se.lexicon.mattias.thymeleaf_formbinding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import se.lexicon.mattias.thymeleaf_formbinding.entity.Customer;
import se.lexicon.mattias.thymeleaf_formbinding.entity.CustomerDetails;
import se.lexicon.mattias.thymeleaf_formbinding.service.CustomerDAO;
import se.lexicon.mattias.thymeleaf_formbinding.service.DetailsDAO;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer",  method = RequestMethod.GET)
public class CustomerController {

    @Autowired
    CustomerDAO dao;

    @Autowired
    DetailsDAO detailsDAO;

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

    /** Find and show everyone in table [ HTML: customer-view.html ] **/
    @GetMapping()
    public String getAllCustomers(Model model) {
        List<Customer> customers = dao.findAll();
        model.addAttribute("customerList", customers);

        return "customer-view.html";
    }

    /** Find and show every detail in table for one customer [ HTML: customer-detail.html ] **/
    @PostMapping(value="/getdetails")
    public String getDetails(@RequestParam("customerId") Integer id, Model model){

        // Get customerDetail from customer ID
        Customer customer = getObject(id);
        Integer detailsId = customer.getDetails().getDetailsId();

        // Get detail information from DB
        Optional<CustomerDetails> details = detailsDAO.findById(detailsId);

        // Send the information to table
        model.addAttribute("detailList", details);

        // Open Form
        return "customer-details.html";
    }

    /**  **/




    /** Convert from Optional Customer to object **/
    public Customer getObject(Integer id){

        Optional<Customer> tempList = dao.findById(id);
        Customer customer = null;

        if(tempList.isPresent()) {
            customer = tempList.get();
        }
        return customer;
    }

    /** Convert from Optional CustomerDetail to object **/
    public CustomerDetails getDetailObject(Integer id){

        Optional<CustomerDetails> tempList = detailsDAO.findById(id);
        CustomerDetails customerDetails = null;

        if(tempList.isPresent()) {
            customerDetails = tempList.get();
        }
        return customerDetails;
    }

}
