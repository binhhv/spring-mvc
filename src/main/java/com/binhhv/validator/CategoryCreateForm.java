package com.binhhv.validator;

import org.hibernate.validator.constraints.NotEmpty;

import com.binhhv.model.Category;

public class CategoryCreateForm {
	@NotEmpty
	private String name="";

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CategoryCreateForm(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public CategoryCreateForm(){}
	public CategoryCreateForm(Category category){
		super();
		this.name = category.getName();
		this.id = category.getId();
	}
}
