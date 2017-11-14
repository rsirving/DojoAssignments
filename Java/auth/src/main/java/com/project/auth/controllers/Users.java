package com.project.auth.controllers;

import com.project.auth.models.*;
import com.project.auth.services.*;
import com.project.auth.validators.*;

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
public class Users{
	//Member variables go here
	@Autowired
	private UserService userService;
	private UserValidator userValidator;
	public Users(UserService userService, UserValidator userValidator){
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/registration")
	public String registerForm(@Valid @ModelAttribute("user") User user){
		return "registrationPage";
	}

	@PostMapping("/registration")
	public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session){
		System.out.println(user.getUsername() + user.getPassword());
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			return "registrationPage";
		} else {
			userService.saveWithUserRole(user);
			return "redirect:/login";
		}
	}

	@RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successfull!");
        }
        return "loginPage";
	}
	
    @RequestMapping(value = {"/", "/home"})
    public String home(Principal principal, Model model) {
		if (principal.getName() == null){
			return "redirect:/login";
		} else {
			String username = principal.getName();
			model.addAttribute("currentUser", userService.findByUsername(username));
			return "homePage";
		}
    }
}
