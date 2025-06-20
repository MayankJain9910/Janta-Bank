package com.jantabank.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.jantabank.entity.TransactionInfo;
import com.jantabank.repository.AccountRepository;
import com.jantabank.repository.TransactionRepository;

@Controller
public class BalanceController 
{
	@Autowired private AccountRepository accountRepository;
	@Autowired private TransactionRepository transactionRepository;
	
	@GetMapping("services/view-balance")
	public ModelAndView getBalanceView(@SessionAttribute("accountno") int accountno)
	{
		int amount=accountRepository.getAmount(accountno);
		ModelAndView modelAndView=new ModelAndView("services/balance/show-balance");
		modelAndView.addObject("amount",amount);
		return modelAndView;
	}
	@GetMapping("services/view-statement")
	public ModelAndView getStatementsView(@SessionAttribute("accountno") int accountno)
	{
		List<TransactionInfo> trList=transactionRepository.getStatements(accountno);
		ModelAndView modelAndView=new ModelAndView("services/balance/statement-view");
		modelAndView.addObject("tlist",trList);
		return modelAndView;
	}
}
