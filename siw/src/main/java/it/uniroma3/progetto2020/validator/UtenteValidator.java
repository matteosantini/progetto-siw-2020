package it.uniroma3.progetto2020.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.service.UtenteService;

@Component
public class UtenteValidator implements Validator{
	
	@Autowired
	UtenteService utenteService;

	@Override
	public boolean supports(Class<?> clazz) {
		return Utente.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Utente u=(Utente) target;
		if(u.getNome().trim().isEmpty())
			errors.rejectValue("nome", "required");
		if(u.getCognome().trim().isEmpty())
			errors.rejectValue("cognome", "required");
	}
	
	
	
	
	

}
