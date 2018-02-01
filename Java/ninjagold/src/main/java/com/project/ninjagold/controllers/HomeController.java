package com.project.ninjagold.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;

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
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController{
	//Member variables go here

	public HomeController(){

	}
	
	@RequestMapping("")
	public String index(HttpSession session){
		System.out.println(session.getAttribute("gold"));
		if (session.getAttribute("gold") == null){
			session.setAttribute("gold", 0);
		}
		if (session.getAttribute("activities") == null){
			session.setAttribute("activities", new ArrayList<String>());
		}
		return "index";
	}

	@RequestMapping("/submit")
	public String redirectToIndex(HttpSession session, @RequestParam(value="activity") String activity){
		Random r = new Random();
		String res = "";
		int newGold = 0;
		int oldGold = (int) session.getAttribute("gold");

		if (activity.equals("farm")){
			newGold = r.nextInt(10+1)+10;
			oldGold += newGold;
			res = "You spent some time at a farm and earned " +newGold+" gold.";
		}
		if (activity.equals("cave")){
			newGold = r.nextInt(5+1)+5;
			oldGold += newGold;
			res = "You explored an old cave and discovered " +newGold+" gold.";
		}
		if (activity.equals("house")){
			newGold = r.nextInt(3+1)+2;
			oldGold += newGold;
			res = "You broke into a house and stole " +newGold+" gold.";
		}
		if (activity.equals("casino")){
			newGold = -50 + r.nextInt(101);
			oldGold += newGold;
			if (newGold < 0) {
				res = "You went to the casino and lost " + newGold + " gold.";
			}
			else if (newGold == 0){
				res = "You went to the casino and broke even.";
			}
			else {
				res = "You went to the casino and won " + newGold + " gold. Lucky you.";
			}
		}
		session.setAttribute("gold", oldGold);
		ArrayList<String> acts = (ArrayList<String>) session.getAttribute("activities");
		acts.add(res);
		session.setAttribute("activities", acts);
		return "redirect:/";
	}
}
