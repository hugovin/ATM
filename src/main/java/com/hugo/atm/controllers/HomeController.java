package com.hugo.atm.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hugo.atm.objects.responses.WithdrawResponse;
import com.hugo.atm.services.WithdrawService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
    
    @Value("${user.balance}")
    private String userbalance;
    
    @Autowired
	private HttpServletRequest request;
    
    @Autowired
    WithdrawService withdrawService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		HttpSession session = request.getSession();
		if (session.getAttribute("logged") != null && session.getAttribute("logged").equals("true")) {
			return new ModelAndView("home");
		}else
		{
			return new ModelAndView("redirect:/");
		}
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.POST)
	public @ResponseBody WithdrawResponse Withdraw(@RequestBody String amount) {
		return withdrawService.GetMoney(Double.parseDouble(amount.split("=")[1]));		
	}
	
	
}
