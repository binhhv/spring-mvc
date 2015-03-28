package com.binhhv.daoImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.criterion.Restrictions;

import com.binhhv.dao.UserDAO;
import com.binhhv.model.User;
import com.binhhv.model.UserAndRole;
import com.binhhv.utils.MD5;
import com.binhhv.utils.Mail;
import com.binhhv.validator.UserCreateForm;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory session;
	@Autowired
	Mail mail;
	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return (User)session.openSession().get(User.class, id);
	}

	
	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		//Session ss = session.openSession();
		//ss.getTransaction().begin();
		Criteria criteria = session.openSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("email", email));
		return (User) criteria.uniqueResult();
		//Query query= ss.createQuery("from "+ User.class.getName()+" where email=:email");
		//query.setParameter("email", email);
		//User user = (User) query.uniqueResult();
		//return user;
	}
	
	@Override
	public User getUserByUsername(String username){
		Criteria criteria = session.openSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User) criteria.uniqueResult();
	}
	@Override
	public User getUserByCode(String code){
		Criteria criteria = session.openSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("confirm_code", code));
		return (User) criteria.uniqueResult();
	}
	
	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Query query = session.openSession().createQuery("from "+ User.class.getName());
		List<User> users = query.list();
		return users;
	}

	@Override
	public Boolean create(UserCreateForm form) {
		// TODO Auto-generated method stub
		Session ss = session.openSession();
		String confirm_code = UUID.randomUUID().toString();
		try {
			ss.getTransaction().begin();
			User user = new User();
			user.setUsername(form.getUsername());
			user.setEmail(form.getEmail());
			user.setConfirm_code(MD5.crypt(confirm_code));
			user.setStatus(0);
			user.setConfirmed(0);
			Date date = new Date();
			user.setCreated_at(date);
			user.setUpdated_at(date);
			new MD5();
			user.setPassword(MD5.crypt(form.getPassword()));
			ss.save(user);
			
			UserAndRole assign = new UserAndRole();
			assign.setRole_id(2);
			assign.setUser_id(user.getId());
			ss.save(assign);
			
			mail.sendMail(user);
			ss.getTransaction().commit();
			return true;
		} catch (Exception e) {
			  e.printStackTrace();
	          ss.getTransaction().rollback();
	        
		}
		  return false;
	}
	
	@Override
	public Boolean activeUser(User user)
	{
		Session ss = session.openSession();
		String confirm_code_new = UUID.randomUUID().toString();
		try {
			ss.getTransaction().begin();
			user.setConfirm_code(MD5.crypt(confirm_code_new));
			user.setStatus(1);
			user.setConfirmed(1);
			Date date = new Date();
			user.setUpdated_at(date);
			ss.update(user);
			ss.getTransaction().commit();
			return true;
		} catch (Exception e) {
			  e.printStackTrace();
	          ss.getTransaction().rollback();
	        
		}
		  return false;
	}
	
	
	@Override
	public User activeUser(String code){
		Boolean active = true;
		User user = getUserByCode(code);
		if(user != null){
			if(activeUser(user)){
				active = true;
			}
			else active = false;
		}
		else active = false;
		
		return (active)?user:null;
	}

}
