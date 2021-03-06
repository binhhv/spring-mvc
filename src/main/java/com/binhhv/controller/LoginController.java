package com.binhhv.controller;


import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.binhhv.contants.WebContants;

@Controller
public class LoginController {

	private static final List<String> INDEX_CSS = WebContants.INDEX_CSS;
	private static final List<String> LOGIN_CSS = WebContants.LOGIN_CSS;
	private static final List<String> INDEX_SCRIPT = WebContants.INDEX_SCRIPT;
	@RequestMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,Model model) {
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		model.addAttribute("styles",LOGIN_CSS );
		//model.addAttribute("scripts",INDEX_SCRIPT);
		return "login";
	}
}
