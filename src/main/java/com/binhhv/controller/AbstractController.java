package com.binhhv.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.bind.annotation.ModelAttribute;

import com.binhhv.contants.WebContants;

public abstract class AbstractController {

	@ModelAttribute(WebContants.MODEL_APP_CONTEXT)
	public String modelAppContext(HttpServletRequest request){
		String contextPath = request.getContextPath();
		return "/".equals(contextPath)?"":contextPath;
	}
}
