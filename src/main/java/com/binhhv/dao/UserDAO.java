package com.binhhv.dao;


import java.util.List;

import com.binhhv.model.User;
import com.binhhv.validator.UserCreateForm;

public interface UserDAO {
    public User getUserById(long id);

    public User getUserByEmail(String email);

    public List<User> getAllUsers();

    public void create(UserCreateForm form);
}
