package com.binhhv.validator;

import org.hibernate.validator.constraints.NotEmpty;

public class BlogCreateForm {

	@NotEmpty
	private String title="";
	@NotEmpty
	private String content="";
	@NotEmpty
	private int category_id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public BlogCreateForm(String title, String content, int category_id) {
		super();
		this.title = title;
		this.content = content;
		this.category_id = category_id;
	}
	public BlogCreateForm() {
		super();
	}
	
	
	
}
