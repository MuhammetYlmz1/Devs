package com.kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodlama.io.Devs.business.abstracts.LanguageService;
import com.kodlama.io.Devs.business.requests.CreateLanguageRequest;
import com.kodlama.io.Devs.business.requests.UpdateLanguageRequest;
import com.kodlama.io.Devs.business.responses.GetAllLanguagesResponse;
import com.kodlama.io.Devs.business.responses.GetByIdLanguageResponse;
import com.kodlama.io.Devs.core.utilities.mappers.ModelMapperService;
import com.kodlama.io.Devs.dataAccess.LanguageRepository;
import com.kodlama.io.Devs.entities.Language;
import com.kodlama.io.Devs.entities.LanguageFramework;
import com.kodlama.io.Devs.exceptions.LanguageNotFoundException;

import lombok.AllArgsConstructor;
import lombok.var;


@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService{
	private LanguageRepository repository;
	private ModelMapperService modelMapperService;
	
	




	@Override
	public List<GetAllLanguagesResponse> getAll() {
		
		List<Language> languages=repository.findAll();
		/*List<GetAllLanguagesResponse> languageResponses=new ArrayList<>();
		languages.forEach(x->{
			GetAllLanguagesResponse response=GetAllLanguagesResponse.builder()
					.id(x.getId())
					.name(x.getName())
					.frameworks(x.getFrameworks().stream().map(LanguageFramework::getFrameworkName).collect(Collectors.toList())).build();
					languageResponses.add(response);
		});
		return languageResponses;*/
		
		List<GetAllLanguagesResponse> getAllLanguagesResponses=languages.stream()
				.map(language -> this.modelMapperService
						.forResponse()
						.map(language, GetAllLanguagesResponse.class))
				.collect(Collectors.toList());
		
		return getAllLanguagesResponses;
	}




	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		for (Language language : repository.findAll()) {
			if (language.getName().equals(createLanguageRequest.getName()) || createLanguageRequest.getName().isEmpty()) {
				throw new Exception("Aynı isim girmeyiniz veya boş bırakmayınız");
			}
		}
		/*Language language=Language.builder()
				.id(0)
				.name(createLanguageRequest.getName())
				.build();
		repository.save(language);*/
		
		Language language=this.modelMapperService.forRequest().map(createLanguageRequest, Language.class);
		repository.save(language);
		
	}




	@Override
	public void delete(int id) {
			repository.deleteById(id);
		
	}




	@Override
	public Language update(UpdateLanguageRequest updateLanguageRequest) throws Exception {
		
		/*for (Language lang : repository.findAll()) {
			if(lang.getId()!=id) {
				throw new Exception("Böyle bir Id yok geçerli bir Id giriniz");
			}
		}*/
		
		/*Language lang= repository.findById(id).get();
		lang.setName(language.getName());
		return repository.save(lang);*/
		Language language=this.modelMapperService.forRequest().map(updateLanguageRequest, Language.class);
		return repository.save(language);
		
		
	}




	@Override
	public GetByIdLanguageResponse getLanguageById(int id) {
		
		Language language=repository.findById(id).orElseThrow(() -> new LanguageNotFoundException("Böyle bir dil yoktur"));
		
		GetByIdLanguageResponse getByIdResponse=this.modelMapperService.forResponse().map(language, GetByIdLanguageResponse.class);
		
		return getByIdResponse;
		/*Language result= repository.findById(id).get();
		
		
		GetByIdLanguageResponse languageResponse=GetByIdLanguageResponse.builder()
				.id(result.getId())
				.name(result.getName())
				.frameworks(result.getFrameworks())
				.build();
				
		
		
		return languageResponse;*/
	}

}