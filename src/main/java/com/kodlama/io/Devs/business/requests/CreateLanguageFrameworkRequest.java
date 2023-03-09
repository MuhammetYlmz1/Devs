package com.kodlama.io.Devs.business.requests;

import com.kodlama.io.Devs.entities.Language;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLanguageFrameworkRequest {
	private String name;
	private int languageId;

}
