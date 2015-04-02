package com.binhhv.service;

import java.util.List;

import com.binhhv.model.User;
import com.binhhv.validator.UserCreateForm;

public interface UserService {
	 	public User getUserById(long id);

	    public User getUserByEmail(String email);

	    public User getUserByCode(String code);
	    
	    public User getUserByUsername(String username);
	    
	    public List<User> getAllUsers();

	    public Boolean create(UserCreateForm form);
	    
	    public Boolean activeUser(User user);
	    
	    public User activeUser(String code);
	    
	    public int getNumbersUser();
}
