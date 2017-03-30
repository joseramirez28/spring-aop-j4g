package org.j4g.spring.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showForm(Map<String, LoginForm> model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processForm(@Valid LoginForm loginForm, BindingResult result, Map<String, LoginForm> model) {
		String userName = "UserName";
		String password = "password";
		if (result.hasErrors()) {
			return "loginform";
		}
		loginForm = (LoginForm) model.get("loginForm");
		if (!loginForm.getUserName().equals(userName) || !loginForm.getPassword().equals(password)) {
			return "loginform";
		}
		model.put("loginForm", loginForm);
		return "loginsuccess";
	}

}