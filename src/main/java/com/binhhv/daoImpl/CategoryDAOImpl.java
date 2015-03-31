package com.binhhv.daoImpl;

import java.nio.channels.SeekableByteChannel;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
		criteria.add(Restrictions.eq("delete_flag", 0));
		return (Category)criteria.uniqueResult();
	}

	@Override
	public Boolean addCategory(CategoryCreateForm categoryForm) {
		try {
			Category category = new Category();
			if(categoryForm.getId() != 0){
				//Session ss = session.getCurrentSession();
				//Transaction trans = getSession().beginTransaction();
				category = this.findCategoryById(categoryForm.getId());
				category.setName(categoryForm.getName());// (Category)session.getCurrentSession().get(Category.class, categoryForm.getId());
				session.getCurrentSession().saveOrUpdate(category);
				//trans.commit();
				//ss.flush();
				//ss.close();
				///session.getCurrentSession().beginTransaction().commit();
			}
			else{
				category.setName(categoryForm.getName());
				category.setDelete_flag(0);
				Date date = new Date();
				category.setCreated_at(date);
				session.getCurrentSession().save(category);
			}
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories(){
		Criteria criteria = session.getCurrentSession().createCriteria(Category.class.getName());
		criteria.add(Restrictions.eq("delete_flag", 0));
		return (List<Category>) criteria.list();
	}
	
	@Override
	public Category findCategoryById(int id){
		return (Category) session.getCurrentSession().get(Category.class, id);
	}
	
	/*private Session getSession() {
		Session sess = session.getCurrentSession();
		if (sess == null) {
			sess = session.openSession();
		}
		return sess;
	}*/
	@Override
	public void deleteCategory(int id){
		Category category = this.findCategoryById(id);
		category.setDelete_flag(1);// (Category)session.getCurrentSession().get(Category.class, categoryForm.getId());
		session.getCurrentSession().saveOrUpdate(category);
	}
}
