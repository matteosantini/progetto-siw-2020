package it.uniroma3.progetto2020.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.progetto2020.model.Credentials;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.service.CredentialService;
import it.uniroma3.progetto2020.session.SessionData;


@Controller
public class AuthController {
	
	@Autowired
	private CredentialService credentialService;
	
    @Autowired
    SessionData sessionData;
    
	@RequestMapping(value="/utenti/register",method=RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("userForm", new Utente());
        model.addAttribute("credentialsForm", new Credentials());

        return "registerUser";
	}
	
	@RequestMapping(value="/utenti/register",method=RequestMethod.POST)
	public String signup(@Valid @ModelAttribute("utente") Utente utente,@Valid @ModelAttribute("credentials") Credentials credentials) {
		credentials.setUtente(utente);
		this.credentialService.saveCredential(credentials);
		return "redirect:/utente/me";	
	}

}
