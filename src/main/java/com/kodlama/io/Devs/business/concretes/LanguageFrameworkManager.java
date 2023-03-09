package com.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.Devs.business.abstracts.LanguageFrameworkService;
import com.kodlama.io.Devs.business.requests.CreateLanguageFrameworkRequest;
import com.kodlama.io.Devs.business.responses.GetAllLanguageFrameworkResponse;
import com.kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.Devs.dataAccess.LanguageFrameworkRepository;
import com.kodlama.io.Devs.dataAccess.LanguageRepository;
import com.kodlama.io.Devs.entities.Language;
import com.kodlama.io.Devs.entities.LanguageFramework;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LanguageFrameworkManager implements LanguageFrameworkService{
	private LanguageFrameworkRepository repository;
	private LanguageRepository languageRepository;
	private ModelMapperService modelMapperService; 

	@Override
	public List<GetAllLanguageFrameworkResponse> getAll() {
		List<LanguageFramework> languageFrameworks=repository.findAll();
		
		List<GetAllLanguageFrameworkResponse> frameworkResponse=new ArrayList<>();
		for (LanguageFramework languageFramework : repository.findAll()) {
			GetAllLanguageFrameworkResponse response=GetAllLanguageFrameworkResponse.builder()
					.id(languageFramework.getId())
					.name(languageFramework.getFrameworkName())
					.language(languageFramework.getLanguage().getName())
					.build();
			frameworkResponse.add(response);
		}
		return frameworkResponse;
		/*List<GetAllLanguageFrameworkResponse> getAllLanguageFrameworkResponses=languageFrameworks.stream()
				.map(framework ->this.modelMapperService
						.forResponse()
						.map(framework, GetAllLanguageFrameworkResponse.class))
				.collect(Collectors.toList());
		
		return getAllLanguageFrameworkResponses;*/
	}


	@Override
	public void add(CreateLanguageFrameworkRequest createRequest) throws Exception {
		
		LanguageFramework framework=LanguageFramework.builder()
				.frameworkName(createRequest.getName()).build();
		
		if(framework.getFrameworkName()==null || createRequest.getName().isEmpty()) {
			throw new Exception("Boş bırakılamaz");
		}
		else if(isFrameworkExist(framework)) {
			throw new Exception("Başka bir Framework giriniz.");
			
		}
		else {
			Language language=languageRepository.findById(createRequest.getLanguageId()).get();
			framework.setLanguage(language);
			repository.save(framework);
		}
		
	}



	private boolean isFrameworkExist(LanguageFramework framework) {
		for (GetAllLanguageFrameworkResponse frameworkResponse : getAll()) {
			if(frameworkResponse.getLanguage().equals(framework.getFrameworkName())) {
				return true;
			}
		}
		return false;
	}



	@Override
	public void delete(int id) {
		
		for (LanguageFramework framework : repository.findAll()) {
			if (framework.getId()==id) {
				repository.deleteById(id);
			}
		}
		
		
	}

}
