package com.project.beltprep.controllers;
import com.project.beltprep.models.*;
import com.project.beltprep.repositories.*;

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
public class Rings{
	//Member variables go here
	private RingRepo ringRepo;
	private UserRepo userRepo;
	public Rings(RingRepo ringRepo, UserRepo userRepo){
		this.ringRepo = ringRepo;
		this.userRepo = userRepo;
	}
	
	@RequestMapping("/ring_creator")
	public String newRing(@ModelAttribute("ring") Ring ring, Principal principal){
		if (userRepo.findByUsername(principal.getName()) == null) {
			return "redirect:/login";
		} else {
			return "ringcreator";
		}
	}	

	@PostMapping("/ring_creator")
	public String forgeRing(@Valid @ModelAttribute("ring") Ring ring, Model model, BindingResult result, Principal principal, RedirectAttributes redirectAttributes){
		if (result.hasErrors()){
			redirectAttributes.addFlashAttribute("errors", "Your ring failed. Try again.");
			return "redirect:/ring_creator";
		} else {
			ring.setUser(userRepo.findByUsername(principal.getName()));
			ringRepo.save(ring);
			return "redirect:/";
		}
	}

	// @PostMapping("/bindring")
	// public String bindRing(@RequestParam)
}
