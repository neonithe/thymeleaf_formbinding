package se.lexicon.mattias.thymeleaf_formbinding.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import se.lexicon.mattias.thymeleaf_formbinding.dto.CustomerDTO;
import se.lexicon.mattias.thymeleaf_formbinding.entity.Customer;
import se.lexicon.mattias.thymeleaf_formbinding.entity.CustomerDetails;
import se.lexicon.mattias.thymeleaf_formbinding.service.CustomerDAO;
import se.lexicon.mattias.thymeleaf_formbinding.service.DetailsDAO;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/customer",  method = RequestMethod.GET)
public class CustomerController {

    @Autowired
    CustomerDAO dao;

    @Autowired
    DetailsDAO detailsDAO;

    List<Customer> customerList = null;

    @PostConstruct
    public void init() {

        /** Create dummy data to database **/

        dao.save(new Customer("Mattias","ma@no.com",new CustomerDetails("street1","333331",
                "city1","1234567891","1234567810")));
        dao.save(new Customer("Sofia",  "so@no.com",new CustomerDetails("street2","333332",
                "city2","1234567892","1234567820")));
        dao.save(new Customer("Linn",   "li@no.com",new CustomerDetails("street3","333333",
                "city3","1234567893","1234567830")));
        dao.save(new Customer("Martin", "mr@no.com",new CustomerDetails("street4","333334",
                "city4","1234567894","1234567840")));
        dao.save(new Customer("Kenny",  "ke@no.com",new CustomerDetails("street5","333335",
                "city5","1234567895","1234567850")));
        dao.save(new Customer("Ewa",    "ew@no.com",new CustomerDetails("street6","333336",
                "city6","1234567896","1234567860")));
        dao.save(new Customer("Birger", "bi@no.com",new CustomerDetails("street7","333337",
                "city7","1234567897","1234567870")));

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

        // Get the information
        String customerId = Integer.toString(customer.getCustomerId());
        String name = customer.getName();
        String email = customer.getEmail();

        // Get detail information from DB
        Optional<CustomerDetails> details = detailsDAO.findById(detailsId);

        // Send the information to top string
        model.addAttribute("id", customerId);
        model.addAttribute("name", name);
        model.addAttribute("email", email);

        // Send the information to table
        model.addAttribute("detailList", details);

        // Open Form
        return "customer-details.html";
    }

    /** Create a customer *********************************************************************************************/

    /** Bind DTO to the form data **/
    @GetMapping("/create")
    public String create(Model model) {

        //Create model attribute to bind form data
        CustomerDTO dto = new CustomerDTO();
        model.addAttribute("customerCreate", dto);

        return "customer-form.html";
    }

    /** Save the data to database and return error if any **/
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("customerCreate") CustomerDTO dto, BindingResult errors) {

        // If any errors found
        if ( errors.hasErrors() ) {
            return "customer-form.html";
        }

        // Create new customer -  add the information from form
        Customer customer =
        new Customer(dto.getName(), dto.getEmail(),
        new CustomerDetails(dto.getStreet(), dto.getZipCode(), dto.getCity(), dto.getHomePhone(), dto.getMobile()));

        // Save the customer
        dao.save(customer);

        return "redirect:/customer";
    }

    /** Deactivate, update, delete ************************************************************************************/


    /** Deactivate activate **/
    @GetMapping(value="/active")
    public String active(@RequestParam("customerId") Integer id){

        // Get customer via id
        Customer customer = getObject(id);

        // Deactivate/activate
        if(customer.isActive() == true) {
            customer.setActive(false);
        } else {
            customer.setActive(true);
        }

        // Save the new settings
        dao.save(customer);

        // Redirect
        return "redirect:/customer";
    }

    /** Update **/
    @PostMapping(value="/update")
    public String update(@RequestParam("customerId") Integer id, Model model){

        // Print id to page
        model.addAttribute("id", id);

        // Get customer > DB
        Customer customer = getObject(id);

        CustomerDTO dto = new CustomerDTO();
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setStreet(customer.getDetails().getStreet());
        dto.setZipCode(customer.getDetails().getZipCode());
        dto.setCity(customer.getDetails().getCity());
        dto.setHomePhone(customer.getDetails().getHomePhone());
        dto.setMobile(customer.getDetails().getMobile());

        // Send the information to the form
        model.addAttribute("customerCreate", dto);

        // Open Form
        return "customer-form.html";
    }

    /** Delete **/
    @GetMapping(value="/delete")
    public String delete(@RequestParam("customerId") Integer id){

        // Remove the Customer
        dao.deleteById(id);

        // Redirect
        return "redirect:/customer";
    }


    /** Sorting the list of customers, search and (De)active **************************************************************/

     @GetMapping("/sortActive")
     public String active(Model model) {

     // Get the list from DB and sort them
     List<Customer> list = dao.findAllByActive(true);

     // Add to the spring model
     model.addAttribute("customerList", list);

     return "customer-view.html";
     }

    @GetMapping("/sortDeactive")
    public String deactive(Model model) {

        // Get the list from DB and sort them
        List<Customer> list = dao.findAllByActive(false);

        // Add to the spring model
        model.addAttribute("customerList", list);

        return "customer-view.html";
    }

    @GetMapping("/sortNameAsc")
    public String sortNameAsc(Model model) {

        // Get the list from DB and sort them
        List<Customer> list = dao.findAllByOrderByNameAsc();

        // Add to the spring model
        model.addAttribute("customerList", list);

        return "customer-view.html";
    }

    @GetMapping("/sortNameDesc")
    public String sortNameDesc(Model model) {

        // Get the list from DB and sort them
        List<Customer> list = dao.findAllByOrderByNameDesc();

        // Add to the spring model
        model.addAttribute("customerList", list);

        return "customer-view.html";
    }

    @GetMapping("/sortId")
    public String sortId(Model model) {

        // Get the list from DB and sort them
        List<Customer> list = dao.findAllByOrderByCustomerIdAsc();

        // Add to the spring model
        model.addAttribute("customerList", list);

        return "customer-view.html";
    }


    @GetMapping("/search")
    public String search(@RequestParam(required = false) String input, Model model) {

        customerList = dao.findAllByName(input);

        if(dao.findAllByName(input).isEmpty()) {
            customerList = dao.findAllByEmail(input);
        }
        model.addAttribute("resultvalue", customerList);

        System.out.println(input);

        return "search.html";
    }

    /** Convert *******************************************************************************************************/

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
