package se.lexicon.mattias.thymeleaf_formbinding.service;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.mattias.thymeleaf_formbinding.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {

    // Is it better to use Optional than list in this case so you don't get null back?
    /** Find By **/
    List<Customer> findAllByEmail(String email);
    List<Customer> findAllByName(String name);

    /** Get list of active / deactivated **/
    List<Customer> findAllByActive(boolean status);

    /** Sort list **/
    List<Customer> findAllByOrderByNameDesc();
    List<Customer> findAllByOrderByCustomerIdAsc();
    List<Customer> findAllByOrderByNameAsc();

}
