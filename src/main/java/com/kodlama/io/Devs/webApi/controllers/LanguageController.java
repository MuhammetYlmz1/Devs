package com.kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlama.io.Devs.business.abstracts.LanguageService;
import com.kodlama.io.Devs.business.requests.CreateLanguageRequest;
import com.kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import com.kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import com.kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import com.kodlama.io.Devs.entities.Language;


@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	private LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
	
	@GetMapping()
	public List<GetAllLanguagesResponse> getAll(){
		return languageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		languageService.add(createLanguageRequest);
	}
	@DeleteMapping("/delete")
	public void delete(int id) {
		 languageService.delete(id);
	}
	@PutMapping("/update")
	public Language update(UpdateLanguageRequest language) throws Exception {
		return languageService.update(language);
	}
	
	@GetMapping("/{id}")
	public GetByIdLanguageResponse getLanguageById(@PathVariable int id) {
		return languageService.getLanguageById(id);
	}
	
	
	
	

}
