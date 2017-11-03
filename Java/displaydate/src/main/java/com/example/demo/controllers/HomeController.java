package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;
@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat dF = new SimpleDateFormat("E, 'the' dd 'of' MMM, YYYY");
		System.out.println(dF.format(date));
		model.addAttribute("dateValue", dF.format(date));
		System.out.println(model);
		return "date";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat tF = new SimpleDateFormat("hh:mm a");
		model.addAttribute("timeValue", tF.format(date));
		return "time";
	}
}
