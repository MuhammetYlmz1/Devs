package com.kodlama.io.Devs.business.responses;

import com.kodlama.io.Devs.entities.Language;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllLanguageFrameworkResponse {

	private int id;
	private String name;
	private String  language;
	
}
