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

	@RequestMapping("/languages/{index}")
	public String oneLanguage(Model model, @PathVariable("index") int index){
		System.out.println("Hello");
		Language language = languageService.findLanguage(index);
		if (language != null){
			model.addAttribute("language", language);
			model.addAttribute("index", index);
			return "oneLanguage";
		} else {
			return "redirect:/languages";
		}
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

	@RequestMapping("/languages/edit/{index}")
	public String editLanguage(@PathVariable("index") int index, Model model) {
		Language language = languageService.findLanguage(index);
		if (language != null){
			model.addAttribute("language", language);
			return "editForm";
		} else {
			return "redirect:/languages";
		}
	}

	@PostMapping("/languages/edit/{index}")
	public String updateLanguage(@PathVariable("index") int index, @Valid @ModelAttribute("language") Language language, BindingResult result){
		if (result.hasErrors()){
			return "editForm";
		} else {
			languageService.updateLanguage(index, language);			
			return "redirect:/languages/{index}";
		}
	}

	@RequestMapping(value="/languages/delete/{index}")
	public String destroyLanguage(@PathVariable("index") int index){
		languageService.destroyLanguage(index);
		return "redirect:/languages";
	}
}
