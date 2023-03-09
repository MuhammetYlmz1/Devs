package com.kodlama.io.Devs.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kodlama.io.Devs.entities.LanguageFramework;

@Repository
public interface LanguageFrameworkRepository extends JpaRepository<LanguageFramework, Integer> {

}
