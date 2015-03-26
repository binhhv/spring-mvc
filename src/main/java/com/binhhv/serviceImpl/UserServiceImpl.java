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

	//@Override
	@Transactional
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userDAO.getAllUsers();
	}

	//@Override
	@Transactional
	public void create(UserCreateForm form) {
		userDAO.create(form);

	}

}
