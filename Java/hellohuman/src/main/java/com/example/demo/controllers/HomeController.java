package com.example.demo.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HomeController {
	@RequestMapping("/")
	public String index(@RequestParam(value="q", required=false, defaultValue="Human") String nameQuery) {
		System.out.println(nameQuery);
		return "Hello " + nameQuery;
	}
}
