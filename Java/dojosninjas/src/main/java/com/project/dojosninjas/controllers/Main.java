package com.project.dojosninjas.controllers;
import com.project.dojosninjas.repositories.*;
import com.project.dojosninjas.models.*;
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
public class Main{
	//Member variables go here
	private DojoRepo dojoRepo;
	private NinjaRepo ninjaRepo;

	public Main(DojoRepo dojoRepo, NinjaRepo ninjaRepo){
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	
	@RequestMapping("")
	public String index(){
		return "index";
	}	

	@RequestMapping("/dojos/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo){
		return "newdojo";
	}
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
		if (result.hasErrors()){
			return "redirect:/";
		} else {
			dojoRepo.save(dojo);
			return "redirect:/";
		}
	}
	@RequestMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja){
		return "newninja";
	}
	@PostMapping("/ninjas/new")
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result){
		if (result.hasErrors()){
			return "redirect:/";
		} else {
			ninjaRepo.save(ninja);
			return "redirect:/";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String showDojo(Model model, @RequestParam("id") Long id){
		model.addAttribute("dojo", dojoRepo.findOne(id));
		model.addAttribute("ninjas", ninjaRepo.findByDojo(id));
		return "onedojo";
	}
}
