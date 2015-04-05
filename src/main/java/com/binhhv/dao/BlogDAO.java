package com.binhhv.dao;

import java.util.List;

import com.binhhv.model.Blog;

public interface BlogDAO {

	public List<Blog> getAllBlogs();
	
	public int getNumbersBlog();
	
	public Blog findBlogById(int id);
	
	public void addBlog(Blog blog);
}
