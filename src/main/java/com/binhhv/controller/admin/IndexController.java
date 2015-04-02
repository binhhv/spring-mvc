package com.binhhv.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value={"/admin","/admin/"})
public class IndexController {

	@RequestMapping(value={"/","/index"}, method=RequestMethod.GET)
	public String viewAdmin(){
		return "admin.home";
	}
}
