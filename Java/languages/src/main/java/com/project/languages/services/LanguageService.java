package com.project.languages.services;
import org.springframework.stereotype.Service;
import com.project.languages.models.Language;
import com.project.languages.repositories.LanguageRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LanguageService {
	private LanguageRepository languageRepository;
	public LanguageService(LanguageRepository languageRepository){
		this.languageRepository = languageRepository;
	}

	private List<Language> languages = new ArrayList<>(Arrays.asList(
		new Language("Java", "James Gosling", "1.8"),
		new Language("Python", "Guido van Rossum", "3.6"),
		new Language("Javascript", "Brendan Eich", "1.9.5.23.247.2")
	));
	// Member variables / service initializations go here

	public List<Language> allLanguages() {
		return languageRepository.findAll();
	}

	public Language findLanguage(Long id){
		return languageRepository.findOne(id);
	}

	public void addLanguage(Language language) {
		languageRepository.save(language);
	}

	public void updateLanguage(Language language){
		languageRepository.save(language);
	}

	public void destroyLanguage(Long id){
		languageRepository.delete(id);
	}
	
	// Crud methods to act on services go here.
}
