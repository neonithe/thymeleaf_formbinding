package se.lexicon.mattias.thymeleaf_formbinding.service;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.mattias.thymeleaf_formbinding.entity.Customer;

public interface CustomerDAO extends JpaRepository<Customer, Integer> {



}
