package com.miw.persistence.user;

import com.miw.model.User;

public interface UserDataService {

	public User getUser(String username) throws Exception;
	public User newUser(User user) throws Exception;
}
