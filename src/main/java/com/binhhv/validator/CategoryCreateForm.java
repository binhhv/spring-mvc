package com.binhhv.validator;

import org.hibernate.validator.constraints.NotEmpty;

import com.binhhv.model.Category;

public class CategoryCreateForm {
	@NotEmpty
	private String name="";

	private int id;
	
	private String tempName="";
	
	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

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

	public CategoryCreateForm(String name, int id,String tempName) {
		super();
		this.name = name;
		this.id = id;
		this.tempName = tempName;
	}
	public CategoryCreateForm(){}
	public CategoryCreateForm(Category category){
		super();
		this.name = category.getName();
		this.tempName = category.getName();
		this.id = category.getId();
	}
}
