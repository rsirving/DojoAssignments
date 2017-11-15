package com.project.beltprep.controllers;
import com.project.beltprep.models.*;
import com.project.beltprep.repositories.*;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.beltprep.validators.UserValidator;

@Controller
public class Users{
	//Member variables go here
	private UserRepo userRepo;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserValidator userValidator;

	public Users(UserRepo userRepo, BCryptPasswordEncoder bCryptPasswordEncoder, UserValidator userValidator){
		this.userRepo = userRepo;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userValidator = userValidator;
	}
	
	@RequestMapping(value={"/", "/home"})
	public String index(){
		return "redirect:/bind_in_darkness";
	}	

	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, 
			@ModelAttribute("user") User user, Model model){
		if (error != null) {
			model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
		}
		if (logout != null) {
			model.addAttribute("logoutMessage", "Logout Successful!");
		}
		return "entrance";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, Model model, BindingResult result, RedirectAttributes redirectAttributes){
		userValidator.validate(user, result);
		if (result.hasErrors()){
			return "redirect:/login";
		}
		List<User> superAdmins = userRepo.findByPermissionLevel(3);
		if (superAdmins.size() == 0){
			userRepo.saveUser(user, bCryptPasswordEncoder, 3);
		} else {
			userRepo.saveUser(user, bCryptPasswordEncoder, 1);
		}
		return "redirect:/login";
	}
}
