package com.binhhv.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.binhhv.dao.BlogDAO;
import com.binhhv.model.Blog;
import com.binhhv.model.Category;
import com.mysql.jdbc.interceptors.SessionAssociationInterceptor;

@Repository
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> getAllBlogs() {
		
		return (List<Blog>) sessionFactory.getCurrentSession().createQuery("from "+Blog.class.getName()).list();
	}
	
	@Override
	public int getNumbersBlog(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Blog.class);
		criteria.add(Restrictions.eq("delete_flag", 0));
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}
}
