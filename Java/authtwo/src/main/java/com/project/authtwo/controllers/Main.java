package com.project.authtwo.controllers;
import com.project.authtwo.services.*;
import com.project.authtwo.models.User;
import java.security.Principal;
import java.util.Date;
import com.project.authtwo.validators.*;

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
public class Main {
    private UserService userService;
	private UserValidator userValidator;	
    public Main(UserService userService, UserValidator userValidator) {
		this.userService = userService;
		this.userValidator = userValidator;
	}
	
	@RequestMapping("/login")
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model, @Valid @ModelAttribute("user") User user) {
        if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "loginpage";
    }
    
    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
        userValidator.validate(user, result);		
        if (result.hasErrors()) {
            return "redirect:/login";
        }
        userService.saveWithUserRole(user);
        return "redirect:/login";
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String username = principal.getName();
        model.addAttribute("currentUser", userService.findByUsername(username));
        return "adminpage";
    }

    @RequestMapping(value = {"/", "/dashboard"})
    public String home(Principal principal, Model model) {
        if (principal.getName() == null){
            return "redirect:/login";
        } else {
            String username = principal.getName();
            User user = userService.findByUsername(username);
            user.setUpdatedAt(new Date());
            model.addAttribute("currentUser", userService.findByUsername(username));
            return "homepage";
        }
    }
	
    // @RequestMapping("/registration")
    // public String registerForm(@Valid @ModelAttribute("user") User user) {
    //     return "registrationpage";
    // }
}