package com.binhhv.controller;



import javax.servlet.http.HttpServletRequest;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.binhhv.contants.WebContants;
import com.binhhv.service.CategoryService;
import com.binhhv.service.UserService;

public abstract class AbstractController {

	@Autowired
	private CategoryService categoryService;
	@ModelAttribute(WebContants.MODEL_APP_CONTEXT)
	public String modelAppContext(HttpServletRequest request){
		String contextPath = request.getContextPath();
		return "/".equals(contextPath)?"":contextPath;
	}
	
	/*@ModelAttribute(WebContants.CATEGORIES_LIST)
	public Object[] getMenu(HttpServletRequest request){
		return categoryService.getAllCategories().toArray();
	}*/
}
