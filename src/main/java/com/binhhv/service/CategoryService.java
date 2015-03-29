package com.binhhv.service;

import com.binhhv.model.Category;
import com.binhhv.validator.CategoryCreateForm;

public interface CategoryService {

	public Category findCategoryByName(String name);
	
	public Boolean addCategory(CategoryCreateForm categoryForm);
}
