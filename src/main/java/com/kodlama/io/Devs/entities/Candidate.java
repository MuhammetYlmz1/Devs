package com.kodlama.io.Devs.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="candidates")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="candidate_name")
	private String name;
	@Column(name="candidate_mail")
	private String mail;
	
	@Column(name="phone_number")
	private String phoneNumber;
	//private int languageId;

}
