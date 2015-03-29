package com.binhhv.dao;

import com.binhhv.model.Category;
import com.binhhv.validator.CategoryCreateForm;

public interface CategoryDAO {

	public Category findCategoryByName(String name);
	
	public Boolean addCategory(CategoryCreateForm category);
}
