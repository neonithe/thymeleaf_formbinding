package se.lexicon.mattias.thymeleaf_formbinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.lexicon.mattias.thymeleaf_formbinding.entity.Customer;
import se.lexicon.mattias.thymeleaf_formbinding.entity.CustomerDetails;
import se.lexicon.mattias.thymeleaf_formbinding.service.CustomerDAO;
import se.lexicon.mattias.thymeleaf_formbinding.service.DetailsDAO;

import java.util.Optional;

@SpringBootApplication
public class ThymeleafFormbindingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafFormbindingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
