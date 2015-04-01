package com.binhhv.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.binhhv.model.Category;
import com.binhhv.service.CategoryService;



@Component
public class CategoryCreateFormValidator implements Validator{

	
	private final CategoryService categoryService;
	@Autowired
	public CategoryCreateFormValidator(CategoryService categoryService) {
		// TODO Auto-generated constructor stub
		this.categoryService = categoryService;
	}
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(CategoryCreateForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		CategoryCreateForm form = (CategoryCreateForm) target;
		validateName(errors, form);
		
	}
	
	private void validateName(Errors errors, CategoryCreateForm categoryCreateForm)
	{
		if(!categoryCreateForm.getTempName().equalsIgnoreCase(categoryCreateForm.getName()) ){
		Category category = categoryService.findCategoryByName(categoryCreateForm.getName());
		if(category != null){
			errors.reject("Category with this name already exists");
		}}
	}

}
