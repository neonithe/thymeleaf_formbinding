package se.lexicon.mattias.thymeleaf_formbinding.service;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.mattias.thymeleaf_formbinding.entity.CustomerDetails;

import java.util.List;

public interface DetailsDAO extends JpaRepository<CustomerDetails, Integer> {

    /** Find by ID **/
  //  List<CustomerDetails> findAllById(Integer id);


}
