package com.binhhv.controller;


import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.binhhv.contants.WebContants;
import com.binhhv.service.BlogService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends AbstractController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final List<String> INDEX_CSS = WebContants.INDEX_CSS;
	private static final List<String> INDEX_SCRIPT = WebContants.INDEX_SCRIPT;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@Autowired
	private BlogService blogService;
	
	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("wellcome to index page", locale);
		model.addAttribute("styles",INDEX_CSS);
		model.addAttribute("scripts",INDEX_SCRIPT);
		model.addAttribute("blogs", blogService.getAllBlogs());
		return "index";
	}
	
}
