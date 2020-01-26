package com.miw.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.miw.model.User;
import com.miw.persistence.user.UserDAO;
import com.miw.persistence.user.UserDataService;

public class MyUserDetailsService implements UserDetailsService {

	private UserDataService userDataService = new UserDAO();
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			User user = userDataService.getUser(username);
			
			if (user == null) {
				throw new UsernameNotFoundException("Usuario no encontrado");
			}
			
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			List<GrantedAuthority> role = new ArrayList<GrantedAuthority>();
			role.add(new SimpleGrantedAuthority(user.getRole()));
			return new org.springframework.security.core.userdetails
					.User(user.getUsername(), 
							user.getPassword().toLowerCase(), 
							enabled, accountNonExpired,
							credentialsNonExpired, accountNonLocked,
							role);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	public UserDataService getUserDataService() {
		return userDataService;
	}

	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}

}
