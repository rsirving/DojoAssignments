package com.project.dojooverflow.controllers;
import com.project.dojooverflow.services.*;

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
public class Main{
	//Member variables go here
	private AnswerService answerService;
	private QuestionService questionService;
	public Main(AnswerService answerService, QuestionService questionService){
		this.answerService = answerService;
		this.questionService = questionService;
	}
	
	@RequestMapping("")
	public String index(){
		return "dashboard";
	}	
}
