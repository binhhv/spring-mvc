package com.binhhv.daoImpl;

import java.util.Date;
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
		
		//return (List<Blog>) sessionFactory.getCurrentSession().createQuery("from "+Blog.class.getName()).list();
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Blog.class.getName());
		criteria.add(Restrictions.eq("delete_flag", 0));
		return (List<Blog>) criteria.list();
	}
	
	@Override
	public int getNumbersBlog(){
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Blog.class);
		criteria.add(Restrictions.eq("delete_flag", 0));
		criteria.setProjection(Projections.rowCount());
		return (Integer) criteria.uniqueResult();
	}
	@Override
	public Blog findBlogById(int id){
		return (Blog) sessionFactory.getCurrentSession().get(Blog.class, id);
	}
	
	@Override
	public void addBlog(Blog blog){
		
		
		if(blog.getId() != 0){
			sessionFactory.getCurrentSession().saveOrUpdate(blog);
		}
		else{
			Date date = new Date();
			blog.setCreated_at(date);
			sessionFactory.getCurrentSession().save(blog);
		}
		
		
	}
	
	@Override
	public void deleteBlog(int id){
		Blog blog = findBlogById(id);
		blog.setDelete_flag(1);
		sessionFactory.getCurrentSession().save(blog);
	}
}
