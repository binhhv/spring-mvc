package com.binhhv.daoImpl;

import java.util.Date;
import java.util.List;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Restrictions;

import com.binhhv.dao.UserDAO;
import com.binhhv.model.User;
import com.binhhv.utils.MD5;
import com.binhhv.validator.UserCreateForm;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory session;
	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return (User)session.getCurrentSession().get(User.class, id);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		Session ss = session.getCurrentSession();
		ss.getTransaction().begin();
		Criteria criteria = ss.createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		return (User) criteria.uniqueResult();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Query query = session.getCurrentSession().createQuery("from "+ User.class.getName());
		List<User> users = query.list();
		return users;
	}

	@Override
	public void create(UserCreateForm form) {
		// TODO Auto-generated method stub
		Session ss = session.getCurrentSession();
		try {
			ss.getTransaction().begin();
			User user = new User();
			user.setUsername(form.getUsername());
			user.setEmail(form.getEmail());
			user.setConfirm_code("");
			user.setStatus(0);
			user.setConfirmed(0);
			Date date = new Date();
			user.setCreated_at(date);
			user.setUpdated_at(date);
			new MD5();
			user.setPassword(MD5.crypt(form.getPassword()));
			ss.save(user);
			ss.getTransaction().commit();
		} catch (Exception e) {
			  e.printStackTrace();
	          ss.getTransaction().rollback();
		}
		
	}

}
