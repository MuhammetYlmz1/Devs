package com.kodlama.io.Devs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlama.io.Devs.entities.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Integer>{

}
