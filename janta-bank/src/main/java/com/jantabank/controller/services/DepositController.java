package com.jantabank.controller.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jantabank.entity.TransactionInfo;

import jakarta.servlet.http.HttpSession;

@Controller
public class DepositController 
{
	@Autowired private com.jantabank.service.AccountService accountService;
	
	@GetMapping("services/deposit-form")
	public String getDepositFormView()
	{
		return "services/deposit/deposit-money-form";
	}
	@GetMapping("services/deposit.do")
	public String depositMoney(int amount,Model model,HttpSession ses)
	{
		TransactionInfo transactionInfo=accountService.depositAmount(amount,(Integer)ses.getAttribute("accountno"));
		ses.setAttribute("transaction", transactionInfo);
		return "redirect:deposit.success";
	}
	@GetMapping("services/deposit.success")
	public String depositMoneySuccess(HttpSession ses,Model model)
	{
		model.addAttribute("transaction", ses.getAttribute("transaction"));
		return "services/deposit/deposit-money-success";
	}
}
