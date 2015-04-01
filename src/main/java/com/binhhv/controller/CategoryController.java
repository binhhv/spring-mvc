package com.binhhv.controller;

import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
import com.binhhv.utils.JsonResponse;

import org.springframework.web.bind.annotation.ResponseBody;

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
	public ModelAndView getNameCategoryCreate(@RequestParam(value="error", required=false)String error,HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView("category","form",new CategoryCreateForm());
		//System.out.print("param "+ error);
		if(error != null){
			try {
				int valueError = Integer.parseInt(error);
				if(valueError > 3 || valueError <= 0){
					mv.addObject("success", 0);
				}
				else{
					mv.addObject("success", valueError);
				}
				
			} catch (Exception e) {
				mv.addObject("success", 0);
			}
		}
		else mv.addObject("success", 0);
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
	@RequestMapping(value="/category",headers="Accept=*/*",method=RequestMethod.POST)
	public @ResponseBody JsonResponse  handleCategoryCreateForm(@Valid @ModelAttribute("form") CategoryCreateForm form,BindingResult bindingResult,Map<String, Object> map){
		JsonResponse res = new JsonResponse();
		if(!bindingResult.hasErrors()){
			categoryService.addCategory(form);
			res.setStatus("SUCCESS");
		}
		else{
			res.setStatus("FAIL");
			System.out.print("error  ====" +bindingResult.getAllErrors() );
			res.setResult(bindingResult.getAllErrors());
		}
		return res;
	}
	
//	@RequestMapping(value="/category",method=RequestMethod.POST)
//	public ModelAndView handleCategoryCreateForm(@Valid @ModelAttribute("form") CategoryCreateForm form,BindingResult bindingResult){
//		//ModelAndView mv = new ModelAndView("category");
//		String typeError = "1";
//		if(form.getId() !=0){
//			typeError ="2";
//		}
//		if(bindingResult.hasErrors()){
//			//mv.addObject("success", 2);
//			//return mv;
//			return new ModelAndView("redirect:/category.html?error="+typeError);
//		}
//		try {
//			if(categoryService.addCategory(form)){
//				//mv.addObject("success", 1);
//				return new ModelAndView("redirect:/category.html");
//			}
//			else{
//				//mv.addObject("success", 2);
//				return new ModelAndView("redirect:/category.html?error="+typeError);
//			}
//			//return mv;
//		} catch (DataIntegrityViolationException e) {
//			//mv.addObject("success",2);
//            //return mv;
//			// TODO: handle exception
//			return new ModelAndView("redirect:/category.html?error="+typeError);
//		}
//		//return mv;
//	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/category/delete/{categoryId}")
	public String deleteBook(@PathVariable("categoryId") int categoryId) {

		categoryService.deleteCategory(categoryId);
		return "redirect:/category.html";
	}
}
