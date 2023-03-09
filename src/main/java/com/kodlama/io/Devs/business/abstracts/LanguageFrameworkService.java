package com.kodlama.io.Devs.business.abstracts;

import java.util.List;

import com.kodlama.io.Devs.business.requests.CreateLanguageFrameworkRequest;
import com.kodlama.io.Devs.business.responses.GetAllLanguageFrameworkResponse;
import com.kodlama.io.Devs.entities.LanguageFramework;


public interface LanguageFrameworkService {
	List<GetAllLanguageFrameworkResponse> getAll();
	void add(CreateLanguageFrameworkRequest request) throws Exception;
	void delete(int id);
	

}
