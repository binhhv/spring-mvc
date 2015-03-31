package com.binhhv.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.binhhv.dao.UserDAO;
import com.binhhv.model.Role;
import com.binhhv.model.User;
import com.binhhv.service.UserService;
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired  
	 private UserDAO userDAO;
	
	@SuppressWarnings("deprecation")
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDAO.getUserByUsername(username); //our own User model class
		
		if(user!=null){
			String password = user.getPassword();
			//additional information on the security object
			boolean enabled = true;//(user.getStatus() == 1) ? true :false;
			boolean accountNonExpired = true;// (user.getStatus() == 1) ? true :false;
			boolean credentialsNonExpired = true;//(user.getStatus() == 1) ? true :false;
			boolean accountNonLocked =true;//(user.getStatus() == 1) ? true :false;
			
			//Let's populate user roles
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(Role role : user.getRoles()){
				authorities.add(new GrantedAuthorityImpl(role.getName()));
			}
			
			//Now let's create Spring Security User object
			org.springframework.security.core.userdetails.User securityUser = new 
					org.springframework.security.core.userdetails.User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
			return securityUser;
		}else{
			throw new UsernameNotFoundException("User Not Found!!!");
		}
	}

}
