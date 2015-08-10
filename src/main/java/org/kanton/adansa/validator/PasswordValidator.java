package org.kanton.adansa.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import org.kanton.adansa.controller.form.ActivationForm;

/**
 * Created by anan on 8/8/15.
 */
public class PasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return ActivationForm.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {

		ActivationForm activationForm = (ActivationForm) o;
		if (!activationForm.getPassword().equals(activationForm.getPassword2())) {
			errors.rejectValue("password2", "valid.password.nomatch");
		}

	}
}
