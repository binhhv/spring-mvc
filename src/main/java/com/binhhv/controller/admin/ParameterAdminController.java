package com.binhhv.controller.admin;

import java.util.Map;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.binhhv.model.json.JsonParameterValueAdmin;
import com.binhhv.service.BlogService;
import com.binhhv.service.CategoryService;
import com.binhhv.service.UserService;


@Controller
public class ParameterAdminController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/admin/getParameter",headers="Accept=*/*",method=RequestMethod.GET)
	public @ResponseBody  JsonParameterValueAdmin handlerGetParameterValue(Map<String, Object> map){
		JsonParameterValueAdmin pAdmin = new JsonParameterValueAdmin();
		pAdmin.setNumBlog(blogService.getNumbersBlog());
		pAdmin.setNumCategory(categoryService.getNumbersCategory());
		pAdmin.setUser(userService.getNumbersUser());
		return pAdmin;
	}
}
