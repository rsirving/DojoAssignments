package com.project.boots.controllers;
import com.project.boots.models.Boot;
import java.util.ArrayList;
import com.project.boots.services.BootService;

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
public class MainController {
	private final BootService bootService;
    public MainController(BootService bootService){
        this.bootService = bootService;
    }
    @RequestMapping("/")
    public String redirect(){
        return "redirect:/boots";
    }
    @RequestMapping("/boots")
    public String boots(Model model) {
        ArrayList<Boot> boots = bootService.allBoots();
        model.addAttribute("boots", boots);
        return "boots";
    }
    @RequestMapping("/boots/{index}")
    public String findBootByIndex(Model model, @PathVariable("index") int index) {
		Boot boot = bootService.findBootByIndex(index);
        model.addAttribute("boot", boot);
        return "showBoot";
	}

	@PostMapping("/boots/new")
    public String createBoot(@Valid @ModelAttribute("boot") Boot boot, BindingResult result) {
        if (result.hasErrors()) {
            return "newBoot";
        }else{
            // Add the boot
            return "redirect:/boots";
        }
	}
	
	@RequestMapping("/boots/edit/{id}")
    public String editBoot(@PathVariable("id") int id, Model model) {
        Boot boot = bootService.findBootByIndex(id);
        if (boot != null){
            model.addAttribute("boot", boot);
            return "editBoot";
        }else{
            return "redirect:/boots";
        }
	}
	
	@PostMapping("/boots/edit/{id}")
    public String updateBoot(@PathVariable("id") int id, @Valid @ModelAttribute("boot") Boot boot, BindingResult result) {
        if (result.hasErrors()) {
            return "editBoot";
        }else{
            bootService.updateBoot(id, boot);
            return "redirect:/boots";
        }
	}
	
	@RequestMapping(value="/boots/delete/{id}")
    public String destroyBoot(@PathVariable("id") int id) {
        bootService.destroyBoot(id);
        return "redirect:/boots";
    }
}