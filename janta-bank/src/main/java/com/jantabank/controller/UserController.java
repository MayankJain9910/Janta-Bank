package com.jantabank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jantabank.entity.User;
import com.jantabank.repository.AccountRepository;
import com.jantabank.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController 
{
	@Autowired private UserService userService;
	@Autowired private AccountRepository accountRepository;
	
	@GetMapping("login")
	public String getLoginView(HttpSession ses)
	{
		if(ses.getAttribute("username")!=null)
			return "redirect:/";
		return "user/login/login-form";
	}
	@GetMapping("registration")
	public String getRegistrationView()
	{
		return "user/registration/registration-form";
	}
	@PostMapping("registration.do")
	public ModelAndView registerUser(User user)
	{
		int accountNo=userService.createUser(user);
		ModelAndView modelAndView=new ModelAndView("user/registration/registration-success");
		modelAndView.addObject("username",user.getFirstname()+" "+user.getLastname());
		modelAndView.addObject("accountno",accountNo);
		return modelAndView;
	}
	@PostMapping("login.do")
	public String authenticateUser(String userid,String password,Model model,HttpSession ses)
	{
		User user=userService.getUser(userid);
		if(user==null)
		{
			model.addAttribute("msg","Entered userid does not exist");
			model.addAttribute("uid",userid);
			return "user/login/login-form";
		}
		if(!password.equals(user.getPassword()))
		{
			model.addAttribute("msg","Entered password is wrong");
			model.addAttribute("uid",userid);
			return "user/login/login-form";
		}
		String username=user.getFirstname()+" "+user.getLastname();
		ses.setAttribute("username", username);
		int accountno=accountRepository.findAccountNoByUserId(userid);
		ses.setAttribute("accountno", accountno);
		return "redirect:/";
	}
	@GetMapping("logout.do")
	public String endUserSession(HttpSession ses,Model model)
	{
		model.addAttribute("username",(String)ses.getAttribute("username"));
		ses.invalidate();
		return "user/login/logout-success";
	}
}
