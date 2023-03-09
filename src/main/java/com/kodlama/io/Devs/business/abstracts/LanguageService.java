package com.kodlama.io.Devs.business.abstracts;

import java.util.List;

import com.kodlama.io.Devs.business.requests.CreateLanguageRequest;
import com.kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import com.kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import com.kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import com.kodlama.io.Devs.entities.Language;


public interface LanguageService {
	List<GetAllLanguagesResponse> getAll();
	void add(CreateLanguageRequest createLanguageRequest) throws Exception;
	void delete(int id);
	Language update(UpdateLanguageRequest updateLanguageRequest) throws Exception;
	GetByIdLanguageResponse getLanguageById(int id);

}
