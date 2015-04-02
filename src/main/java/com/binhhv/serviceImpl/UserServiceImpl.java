package com.binhhv.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binhhv.dao.UserDAO;
import com.binhhv.model.User;
import com.binhhv.service.UserService;
import com.binhhv.validator.UserCreateForm;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	//@Override
	@Transactional
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return userDAO.getUserById(id);
	}

	//@Override
	@Transactional
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userDAO.getUserByEmail(email);
	}

	@Transactional
	public User getUserByCode(String code) {
		// TODO Auto-generated method stub
		return userDAO.getUserByCode(code);
	}
	//@Override
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.getAllUsers();
	}

	//@Override
	@Transactional
	public Boolean create(UserCreateForm form) {
		return userDAO.create(form);
		
	}
	
	@Transactional
	public Boolean activeUser(User user){
		return userDAO.activeUser(user);
	}
	
	@Transactional
	public User activeUser(String code){
		return userDAO.activeUser(code);
	}
	@Transactional
	public User getUserByUsername(String username){
		return userDAO.getUserByUsername(username);
	}
	
	@Override
	@Transactional
	public int getNumbersUser(){
		return  userDAO.getNumbersUser();
	}
}
