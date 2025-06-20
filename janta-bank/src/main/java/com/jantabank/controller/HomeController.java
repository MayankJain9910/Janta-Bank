package com.jantabank.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController 
{
	@GetMapping("/")
	public String getHomeView(HttpSession ses)
	{
		if(ses.getAttribute("username")==null)
			return "user/login/login-form";
		return "home/homepage";
}
}
