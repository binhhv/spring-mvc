package com.binhhv.dao;

import java.util.List;

import com.binhhv.model.Category;
import com.binhhv.validator.CategoryCreateForm;

public interface CategoryDAO {

	public Category findCategoryByName(String name);
	
	public Boolean addCategory(CategoryCreateForm category);
	
	public List<Category> getAllCategories();
	
	public Category findCategoryById(int id);
	
	public void deleteCategory(int id);
	
	public int getNumbersCategory();
}
