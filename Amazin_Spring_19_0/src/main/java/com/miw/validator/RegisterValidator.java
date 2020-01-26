package com.miw.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.miw.model.UserData;

public class RegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserData.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserData user = (UserData) target;
		
		if(!user.getPassword().equals(user.getRepassword())) {
			errors.rejectValue("password", "", "Las contraseñas no coinciden");
		}
		
	}

}
