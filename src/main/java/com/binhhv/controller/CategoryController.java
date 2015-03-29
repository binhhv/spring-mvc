package com.binhhv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.binhhv.service.CategoryService;
import com.binhhv.validator.CategoryCreateForm;
import com.binhhv.validator.CategoryCreateFormValidator;

@Controller
public class CategoryController extends AbstractController{
	
	@Autowired
	private CategoryService categoryService;
	private CategoryCreateFormValidator categoryCreateFormValidator;
	
	@Autowired
	public CategoryController(CategoryService categoryService, CategoryCreateFormValidator categoryCreateFormValidator){
		this.categoryService = categoryService;
		this.categoryCreateFormValidator = categoryCreateFormValidator;
	}
	@InitBinder("form")
	public void initBinder(WebDataBinder binder){
		binder.addValidators(categoryCreateFormValidator);
	}
	@RequestMapping(value="/category/create",method=RequestMethod.GET)
	public ModelAndView getNameCategoryCreate(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("category","form",new CategoryCreateForm());
		mv.addObject("success", 0);
		return mv;
	}
	@RequestMapping(value="/category/create",method=RequestMethod.POST)
	public ModelAndView handleCategoryCreateForm(@Valid @ModelAttribute("form") CategoryCreateForm form,BindingResult bindingResult){
		ModelAndView mv = new ModelAndView("category");
		if(bindingResult.hasErrors()){
			mv.addObject("success", 0);
			return mv;
		}
		try {
			if(categoryService.addCategory(form)){
				mv.addObject("success", 1);
			}
			else{
				mv.addObject("success", 0);
			}
			return mv;
		} catch (DataIntegrityViolationException e) {
			mv.addObject("success",0);
            //return mv;
			// TODO: handle exception
		}
		return mv;
	}
}
