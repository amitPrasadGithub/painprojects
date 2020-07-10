package com.vb.RESTExceptionHandler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.vb.RESTExceptionHandler.exception.NoStudentFoundException;

@Controller
@ControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = NullPointerException.class)
	public String handlerNPE(Model model) {
		String msg = "Your request can not be processed at this time please try later!!Application specific handling";
		model.addAttribute("errorMessage", msg);
		return "error";
	}
	
	@ExceptionHandler(value = NoStudentFoundException.class)
	public String handleNSFE(Model model) {
		String msg = "No such student found";
		model.addAttribute("errorMessage", msg);
		return "error";
	}
	
}
