package com.binhhv.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.binhhv.contants.WebContants;
import com.binhhv.model.Category;
import com.binhhv.service.CategoryService;
import com.binhhv.validator.CategoryCreateForm;
import com.binhhv.validator.CategoryCreateFormValidator;

@Controller
public class CategoryController {
	
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
	
	@RequestMapping(value="/category",method=RequestMethod.GET)
	public ModelAndView getNameCategoryCreate(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("category","form",new CategoryCreateForm());
		mv.addObject("success", 0);
		mv.addObject("scripts", WebContants.CATEGORY_SCRIPT);
		mv.addObject("categories", categoryService.getAllCategories());
		return mv;
	}
	@RequestMapping("/get/{categoryId}")
	public String getBook(@PathVariable int categoryId, Map<String, Object> map) {

		//Book book = bookService.getBook(bookId);
		Category category = categoryService.findCategoryById(categoryId);
		map.put("form", new CategoryCreateForm(category));
		return "categoryForm";
	}
	@RequestMapping(value="/category",method=RequestMethod.POST)
	public ModelAndView handleCategoryCreateForm(@Valid @ModelAttribute("form") CategoryCreateForm form,BindingResult bindingResult){
		ModelAndView mv = new ModelAndView("category");
		System.out.print(form.getId());
		if(bindingResult.hasErrors()){
			mv.addObject("success", 2);
			return mv;
		}
		try {
			if(categoryService.addCategory(form)){
				//mv.addObject("success", 1);
				return new ModelAndView("redirect:/category.html");
			}
			else{
				mv.addObject("success", 2);
			}
			return mv;
		} catch (DataIntegrityViolationException e) {
			mv.addObject("success",2);
            //return mv;
			// TODO: handle exception
		}
		return mv;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/category/delete/{categoryId}")
	public String deleteBook(@PathVariable("categoryId") int categoryId) {

		categoryService.deleteCategory(categoryId);
		return "redirect:/category.html";
	}
}
