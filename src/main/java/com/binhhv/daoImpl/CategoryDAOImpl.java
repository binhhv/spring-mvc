package com.binhhv.daoImpl;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.CreateKeySecondPass;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.binhhv.dao.CategoryDAO;
import com.binhhv.model.Category;
import com.binhhv.validator.CategoryCreateForm;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory session;
	@Override
	public Category findCategoryByName(String name) {
		Criteria criteria = session.getCurrentSession().createCriteria(Category.class);
		criteria.add(Restrictions.eq("name", name));
		return (Category)criteria.uniqueResult();
	}

	@Override
	public Boolean addCategory(CategoryCreateForm categoryForm) {
		try {
			Category category = new Category();
			category.setName(categoryForm.getName());
			category.setDelete_flag(0);
			Date date = new Date();
			category.setCreated_at(date);
			session.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

}
