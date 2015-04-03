package com.binhhv.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.binhhv.contants.WebContants;
import com.binhhv.service.BlogService;
import com.binhhv.validator.BlogCreateForm;
import com.binhhv.validator.CategoryCreateForm;

@Controller
@RequestMapping(value={"/admin","/admin/"})
public class AdminBlogController {
	
	//@Autowired
	private BlogService blogService;
	private BlogCreateForm blogCreateForm;
	
	@Autowired
	public AdminBlogController(BlogService blogService, BlogCreateForm blogCreateForm){
		this.blogService = blogService;
		this.blogCreateForm = blogCreateForm;
	}
	/*@InitBinder("form")
	public void initBinder(WebDataBinder binder){
		binder.addValidators(blogCreateForm);
	}*/
	@RequestMapping(value="/blog",method=RequestMethod.GET)
	public ModelAndView getNameCategoryCreate(@RequestParam(value="error", required=false)String error,HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("admin.blog","form",new BlogCreateForm());
		mv.addObject("blogs", blogService.getAllBlogs());
		return mv;
	}
	
	@RequestMapping(value="/blog",method=RequestMethod.POST)
	public @ResponseBody String handleCreateCategory(@Valid @ModelAttribute("form") BlogCreateForm blogCreateForm){
		
		return "";
	}
}
