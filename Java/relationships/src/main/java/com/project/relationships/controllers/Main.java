package com.project.relationships.controllers;
import com.project.relationships.models.*;
import com.project.relationships.services.*;

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
public class Main{
	//Member variables go here
	private final PersonService personService;
	private final LicenseService licenseService;
	public Main(PersonService personService, LicenseService licenseService){
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("")
	public String index(){
		return "index";
	}

	@RequestMapping("/persons/new")
	public String newPersonForm(@ModelAttribute("person") Person person){
		return "newperson";
	}
	@PostMapping("/persons/new")
	public String newPersonSubmit(@Valid @ModelAttribute("person") Person person, BindingResult result){
		if (result.hasErrors()){
			return "redirect:/";
		} else {
			personService.newPerson(person);
			return "redirect:/";
		}
	}
	@RequestMapping("/persons/{id}")
	public String profileShow(Model model, @RequestParam ("id") Long id){
		Person person = personService.onePerson(id);
		if (person != null){
			model.addAttribute("person", person);
			return "profile";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping("/licenses/new")
	public String newLicenseForm(@ModelAttribute("license") License license, Model model){
		model.addAttribute("persons", personService.allPersons());
		return "newlicense";
	}

	@PostMapping("/licenses/new")
	public String submitNewLicense(@Valid @ModelAttribute("license") License license, BindingResult result){
		if (result.hasErrors()){
			return "redirect:/";
		} else {
			licenseService.newLicense(license);
			return "redirect:/";
		}
	}
}
