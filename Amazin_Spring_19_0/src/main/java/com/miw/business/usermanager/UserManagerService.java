package com.miw.business.usermanager;

import com.miw.model.User;

public interface UserManagerService {
	public User getUser(String username) throws Exception;
	public User newUser(User user) throws Exception;
}
