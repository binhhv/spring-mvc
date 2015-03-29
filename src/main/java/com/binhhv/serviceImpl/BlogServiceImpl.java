package com.binhhv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binhhv.dao.BlogDAO;
import com.binhhv.model.Blog;
import com.binhhv.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDAO blogDAO;
	@Override
	@Transactional
	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return blogDAO.getAllBlogs();
	}

}
