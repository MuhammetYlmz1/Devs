package com.kodlama.io.Devs.business.responses;

import java.util.List;

import com.kodlama.io.Devs.entities.LanguageFramework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdLanguageResponse {
	
	private int id;
	private String name;
	private List<LanguageFramework> frameworks;
	
	
}
