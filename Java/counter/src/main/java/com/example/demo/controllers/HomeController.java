package com.example.demo.controllers;

import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if (session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		} else {
			session.setAttribute("counter", (int) session.getAttribute("counter")+1);
		}
		return "index";
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		if (session.getAttribute("counter") == null) {
			session.setAttribute("counter", 0);
		}
		return "counter";
	}
}
