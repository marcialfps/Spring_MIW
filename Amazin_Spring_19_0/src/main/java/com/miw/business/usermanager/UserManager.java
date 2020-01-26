package com.miw.business.usermanager;

import org.apache.log4j.Logger;

import com.miw.model.User;
import com.miw.persistence.user.UserDataService;

public class UserManager implements UserManagerService {
	Logger logger = Logger.getLogger(this.getClass());
	private UserDataService userDataService=null;

	@Override
	public User getUser(String username) throws Exception {
		logger.debug("Asking for user");
		userDataService.getUser(username);
		return null;
	}

	@Override
	public User newUser(User user) throws Exception {
		return userDataService.newUser(user);
	}

	public UserDataService getUserDataService() {
		return userDataService;
	}

	public void setUserDataService(UserDataService userDataService) {
		this.userDataService = userDataService;
	}

	
}
