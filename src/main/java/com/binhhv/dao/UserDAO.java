package com.binhhv.dao;


import java.util.List;

import com.binhhv.model.User;
import com.binhhv.validator.UserCreateForm;

public interface UserDAO {
    public User getUserById(long id);

    public User getUserByUsername(String username);
    
    public User getUserByEmail(String email);
    
    public User getUserByCode(String code);
    
    public List<User> getAllUsers();

    public Boolean create(UserCreateForm form);
    
    public Boolean activeUser(User user);
    
    public User activeUser(String code);
    
    public int getNumbersUser();
}
