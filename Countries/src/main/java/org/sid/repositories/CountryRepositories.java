package org.sid.repositories;

import java.io.Serializable;

import org.sid.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepositories extends JpaRepository<Country, Integer>{
	
}
