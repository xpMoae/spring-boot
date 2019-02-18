package com.basic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SuccessionController {

	@PostMapping("requestTest")
	public Object requestTest(HttpServletRequest request) {
		request.getSession().setAttribute("userContext", "userContext");
		System.out.println(request.getParameter("test"));
		System.out.println(request.getSession().getAttribute("userContext"));
		
		return null;
	}
}
