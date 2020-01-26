package com.miw.persistence.user;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;

import com.miw.model.User;
import com.miw.persistence.Dba;

public class UserDAO implements UserDataService {

	protected Logger logger = Logger.getLogger(getClass());

	@Override
	public User getUser(String username) throws Exception {

		List<User> userList = null;

		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();

			userList = em.createQuery("Select u From User u Where u.username= ?", User.class)
					.setParameter(1, username)
					.getResultList();

			if(!userList.isEmpty()) {
				logger.debug("Result user: "+ userList.get(0).toString());
			} else {
				return null;
			}

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return userList.get(0);
	}

	@Override
	public User newUser(User user) throws Exception {
		Dba dba = new Dba();
		try {
			EntityManager em = dba.getActiveEm();
			em.persist(user);
			em.getTransaction().commit();

			logger.debug("Alta usuario: "+ user.toString());

		} finally {
			// 100% sure that the transaction and entity manager will be closed
			dba.closeEm();
		}

		// We return the result
		return user;
	}

}
