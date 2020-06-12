package it.uniroma3.progetto2020.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.progetto2020.model.Credentials;
import it.uniroma3.progetto2020.service.CredentialService;

@Component
public class CredentialValidator implements Validator{
	
	@Autowired
	CredentialService credentialsService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Credentials.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Credentials c=(Credentials) target;
		if(c.getUsername().isEmpty())
			errors.rejectValue("username", "required");
		if(c.getPassword().isEmpty())
			errors.rejectValue("password", "required");
	}
	
	
	

}
