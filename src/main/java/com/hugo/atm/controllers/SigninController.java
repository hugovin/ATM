package com.hugo.atm.controllers;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;
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

@Controller
public class SigninController {

	@Value("${user.pin}")
	private String userPin;

	@Autowired
	private HttpServletRequest request;

	private static final Logger logger = LoggerFactory
			.getLogger(SigninController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "signin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String doLogin(@RequestBody String pin) {
		// I dont know why is getting the property pin from the request in this
		// way: pin=xxxx. and there's no time to figure it out
		// thats the reason Im doing this horrible split
		if (pin.split("=")[1].equals(userPin)) {
			HttpSession session = request.getSession();
			session.setAttribute("logged", "true");
			logger.info("login success fo user at: "+ new DateTime().toString());
			return "";
		} else {
			return "Invalid Pin";
		}
	}

}
