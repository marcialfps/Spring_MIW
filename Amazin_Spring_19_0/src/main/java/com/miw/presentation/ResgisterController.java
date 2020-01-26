package com.miw.presentation;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.miw.business.usermanager.UserManagerService;
import com.miw.model.User;
import com.miw.model.UserData;
import com.miw.validator.RegisterValidator;

@Controller
@RequestMapping("register")
public class ResgisterController {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	UserManagerService userManagerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute UserData userData, BindingResult result) {
		RegisterValidator registerValidator = new RegisterValidator();
		registerValidator.validate(userData, result);
		
		try {
			if(this.userManagerService.getUser(userData.getUsername()) != null) {
				logger.debug("El usuario ya existe");
				result.rejectValue("username", "", "El usuario ya existe");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (result.hasErrors()) {
			return "register";
		}
		
		try {
			User u = new User();
			u.setEmail(userData.getEmail());
			u.setPassword(userData.getPassword());
			u.setUsername(userData.getUsername());
			u.setRole("ROLE_ADMIN");
			this.userManagerService.newUser(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:login";
	}
	
	@ModelAttribute
	private UserData getUserData() {
		return new UserData();
	}

	public UserManagerService getUserManagerService() {
		return userManagerService;
	}

	public void setUserManagerService(UserManagerService userManagerService) {
		this.userManagerService = userManagerService;
	}
}
