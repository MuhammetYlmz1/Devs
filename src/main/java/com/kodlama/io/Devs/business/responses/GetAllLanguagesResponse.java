package com.kodlama.io.Devs.business.responses;

import java.util.List;

import com.kodlama.io.Devs.entities.LanguageFramework;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllLanguagesResponse {
	private int id;
	private String name;
	private List<LanguageFramework> frameworks;
}
