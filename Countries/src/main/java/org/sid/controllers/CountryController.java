package org.sid.controllers;

import org.sid.entities.Country;
import org.sid.repositories.CountryRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CountryController {

	@Autowired
	private CountryRepositories countryRepositories; 
	
	@GetMapping("/")
	public String showPage(Model model, @RequestParam(defaultValue="0") int page ) {
		model.addAttribute("dataJ", countryRepositories.findAll(new PageRequest(page, 4)));	
		model.addAttribute("currentPage",page);
		return "index";		
	}
	
	@PostMapping("/save")
	public String save(Country c) {		
		countryRepositories.save(c);		
		return "redirect:/";		
	}
	
	@GetMapping("/delete")
	public String deleteCountry(Integer id) {		
		countryRepositories.deleteById(id);	
		return "redirect:/";		
	}

	@GetMapping("/findOne")
	@ResponseBody
	public Country findOne(Integer id) {				
		return countryRepositories.findById(id).orElse(null);		
	}

}
