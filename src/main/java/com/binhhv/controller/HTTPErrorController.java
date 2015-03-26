package com.binhhv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.ListUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




import com.binhhv.contants.WebContants;

@Controller(value=WebContants.ACTION_ERRORS)
@RequestMapping("/" + WebContants.ACTION_ERRORS)
public class HTTPErrorController extends AbstractController {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static String ERRORS_404 = WebContants.ERRORS_404;
	private static final List<String> INDEX_CSS = WebContants.INDEX_CSS;
	private static final List<String> INDEX_SCRIPT = WebContants.INDEX_SCRIPT;
	//private static final List<String> LOGIN_CSS = WebContants.LOGIN_CSS;
	//private final static ArrayList<String> ERRORS_CSS = RimentSpringStyleContants.ERRORS_CSS;
	@RequestMapping(value="/"+ERRORS_404)
    public String handle404(HttpServletRequest request,
			HttpServletResponse response,Locale locale, Model model) {
    	//ModelAndView mv = new ModelAndView(RimentSpringContants.ERRORS_VIEW + "/" + ERRORS_404);
    	//mv.addObject("css",ERRORS_CSS);
		model.addAttribute("styles", INDEX_CSS);
		model.addAttribute("scripts",INDEX_SCRIPT);
    	return "404";
    }

    
}
