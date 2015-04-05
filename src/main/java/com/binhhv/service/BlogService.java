package com.binhhv.service;

import java.util.List;

import com.binhhv.model.Blog;

public interface BlogService {

	public List<Blog> getAllBlogs();
	
	public int getNumbersBlog();
	
	public Blog findBlogById(int id);
	
	public void addBlog(Blog blog);
}
