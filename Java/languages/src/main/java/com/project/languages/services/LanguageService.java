package com.project.languages.services;

import com.project.languages.models.Language;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LanguageService {
	private List<Language> languages = new ArrayList<>(Arrays.asList(
		new Language("Java", "James Gosling", "1.8"),
		new Language("Python", "Guido van Rossum", "3.6"),
		new Language("Javascript", "Brendan Eich", "1.9.5.23.247.2")
	));
	// Member variables / service initializations go here

	public List<Language> allLanguages() {
		return languages;
	}

	public Language findLanguage(int id){
		if (id < languages.size()){
			return languages.get(id);
		} else {
			return null;
		}
	}

	public void addLanguage(Language language) {
		System.out.println("Hi");
		languages.add(language);
	}

	public void updateLanguage(int id, Language language){
		System.out.println("CHECK");
		if (id < languages.size()){
			languages.set(id, language);
		}
	}

	public void destroyLanguage(int id){
		if (id < languages.size()){
			languages.remove(id);
		}
	}
	
	// Crud methods to act on services go here.
}
