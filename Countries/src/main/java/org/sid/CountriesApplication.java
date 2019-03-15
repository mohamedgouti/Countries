package org.sid;

import org.sid.entities.Country;
import org.sid.repositories.CountryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesApplication implements CommandLineRunner {

	@Autowired
	private CountryRepositories countryRepositories;
	
	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
				
		Country c1 = new Country();
		c1.setName("England");
		c1.setCapital("London");	
		Country c2 = new Country("Grece","Athènes");
	
		countryRepositories.save(new Country("Earth","World"));
		countryRepositories.save(new Country("China","Pekin"));
		countryRepositories.save(new Country("Germany","Berlin"));
		countryRepositories.save(new Country("Tunisie","Tunis"));
		countryRepositories.save(new Country("France","Paris"));
		countryRepositories.save(new Country("Italie","Rome"));
		countryRepositories.save(new Country("US","NY"));
		countryRepositories.save(new Country("Espagne","Madrid"));		
	    countryRepositories.save(c1);
	    countryRepositories.save(c2);
	
	}
}
