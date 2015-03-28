package com.binhhv.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binhhv.dao.UserDAO;
import com.binhhv.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDAO.getUserByUsername(username);
		if(user != null){
			
		}
		return null;
	}

}
