package com.binhhv.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.binhhv.dao.BlogDAO;
import com.binhhv.model.Blog;

@Repository
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> getAllBlogs() {
		
		return (List<Blog>) sessionFactory.getCurrentSession().createQuery("from "+Blog.class.getName()).list();
	}

}
