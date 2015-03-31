package com.binhhv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binhhv.dao.CategoryDAO;
import com.binhhv.model.Category;
import com.binhhv.service.CategoryService;
import com.binhhv.validator.CategoryCreateForm;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;
	@Override
	@Transactional
	public Category findCategoryByName(String name) {
		// TODO Auto-generated method stub
		return categoryDAO.findCategoryByName(name);
	}

	@Override
	@Transactional
	public Boolean addCategory(CategoryCreateForm categoryForm) {
		// TODO Auto-generated method stub
		return categoryDAO.addCategory(categoryForm);
	}

	@Override
	@Transactional
	public List<Category> getAllCategories(){
		return categoryDAO.getAllCategories();
	}
	
	@Override
	@Transactional
	public Category findCategoryById(int id){
		return categoryDAO.findCategoryById(id);
	
	}
	
	@Override
	@Transactional
	public void deleteCategory(int id){
		categoryDAO.deleteCategory(id);
	}
}
