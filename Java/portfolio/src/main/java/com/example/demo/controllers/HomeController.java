package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
            return "Index";
    }
    @RequestMapping("/about")
    public String about() {
    	return "About";
    }
    @RequestMapping("/projects")
    public String projects() {
    	return "Projects";
    }
}
