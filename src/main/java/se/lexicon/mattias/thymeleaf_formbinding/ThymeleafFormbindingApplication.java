package se.lexicon.mattias.thymeleaf_formbinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.mattias.thymeleaf_formbinding.controller.CustomerController;
import se.lexicon.mattias.thymeleaf_formbinding.entity.Customer;
import se.lexicon.mattias.thymeleaf_formbinding.entity.CustomerDetails;
import se.lexicon.mattias.thymeleaf_formbinding.service.CustomerDAO;
import se.lexicon.mattias.thymeleaf_formbinding.service.DetailsDAO;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ThymeleafFormbindingApplication implements CommandLineRunner {
/**
	@Autowired
	CustomerDAO dao;

	@Autowired
	CustomerController cusCon;
**/
	public static void main(String[] args) {
		SpringApplication.run(ThymeleafFormbindingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/**
		Customer cus1 = cusCon.getObject(1);
			cus1.setActive(false);
				dao.save(cus1);
		Customer cus2 = cusCon.getObject(2);
			cus2.setActive(true);
				dao.save(cus2);
		Customer cus3 = cusCon.getObject(3);
				cus3.setActive(false);
					dao.save(cus3);

		List<Customer> list = dao.findAllByOrderByActive();
		System.out.println();
		list.forEach(System.out::println);
**/

	}
}
