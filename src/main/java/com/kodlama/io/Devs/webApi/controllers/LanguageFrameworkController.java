package com.kodlama.io.Devs.webApi.controllers; 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.Devs.business.abstracts.LanguageFrameworkService;
import com.kodlama.io.Devs.business.requests.CreateLanguageFrameworkRequest;
import com.kodlama.io.Devs.business.responses.GetAllLanguageFrameworkResponse;
import com.kodlama.io.Devs.entities.LanguageFramework;


@RestController
@RequestMapping("/api/languageframework")
public class LanguageFrameworkController {
	private LanguageFrameworkService languageFrameworkService;
	
	@Autowired
	public LanguageFrameworkController(LanguageFrameworkService languageFrameworkService) {
		super();
		this.languageFrameworkService = languageFrameworkService;
	}
	
	@GetMapping()
	public List<GetAllLanguageFrameworkResponse> getAll(){
		return languageFrameworkService.getAll(); 
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageFrameworkRequest request) throws Exception {
		languageFrameworkService.add(request);
	}
	@DeleteMapping("/delete")
	public void delete(int id) {
		languageFrameworkService.delete(id);
	}
	
	

}
