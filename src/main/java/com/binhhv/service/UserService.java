package com.binhhv.service;

import java.util.List;

import com.binhhv.model.User;
import com.binhhv.validator.UserCreateForm;

public interface UserService {
	 	public User getUserById(long id);

	    public User getUserByEmail(String email);

	    public List<User> getAllUsers();

	    public Boolean create(UserCreateForm form);
}
