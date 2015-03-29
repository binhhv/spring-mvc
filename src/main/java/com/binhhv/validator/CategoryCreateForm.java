package com.binhhv.validator;

import org.hibernate.validator.constraints.NotEmpty;

public class CategoryCreateForm {
	@NotEmpty
	private String name="";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
