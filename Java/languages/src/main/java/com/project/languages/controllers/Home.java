package com.project.languages.controllers;
import com.project.languages.models.Language;
import com.project.languages.services.LanguageService;
import java.util.ArrayList;
import java.util.List;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Home{
	//Member variables go here
	private final LanguageService languageService;

	public Home(LanguageService languageService){
		this.languageService = languageService;
	}
	
	@RequestMapping("")
	public String redirToIndex(){
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language){
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "index";
	}

	@RequestMapping("/languages/{id}")
	public String oneLanguage(Model model, @PathVariable("id") Long id){
		model.addAttribute("language", languageService.findLanguage(id));
		return "oneLanguage";
	}

	@PostMapping("/languages/new")
	public String addLanguage(@Valid @ModelAttribute("language") Language language, BindingResult result){
		if (result.hasErrors()){
			return "redirect:/languages";
		} else {
			languageService.addLanguage(language);
			return "redirect:/languages";
		}
	}

	@RequestMapping("/languages/edit/{id}")
	public String editLanguage(@PathVariable("id") Long id, Model model) {
		Language language = languageService.findLanguage(id);
		if (language != null){
			model.addAttribute("language", language);
			return "editForm";
		} else {
			return "redirect:/languages";
		}
	}

	@PostMapping("/languages/edit/{id}")
	public String updateLanguage(@PathVariable("id") Long id, @Valid @ModelAttribute("language") Language language, BindingResult result){
		if (result.hasErrors()){
			return "editForm";
		} else {
			languageService.updateLanguage(language);			
			return "redirect:/languages/{id}";
		}
	}

	@RequestMapping(value="/languages/delete/{id}")
	public String destroyLanguage(@PathVariable("id") Long id){
		languageService.destroyLanguage(id);
		return "redirect:/languages";
	}
}
