package com.vb.RESTExceptionHandler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping(value = "/welcome")
	public String welcome(Model model) {
		model.addAttribute("msg", "Welcome to REST");
		String str = null;
		str.length();
		return "welcome";
	}
	@ExceptionHandler(value = NullPointerException.class)
	public String handlerNullPointerException(Model model) {
		String str = "Your request can not be processed at this time. please try later!!Controller Specific handling";
		model.addAttribute("errorMessage", str);
		return "error";
		
	}
}
