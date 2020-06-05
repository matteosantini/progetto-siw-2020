package it.uniroma3.progetto2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.progetto2020.model.Credentials;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.service.CredentialService;

@Controller
public class AuthController {
	
	@Autowired
	private CredentialService credentialService;
	
	@RequestMapping(value="/utenti/register",method=RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("utente", new Utente());
		model.addAttribute("credentials",new Credentials());
		return "addUtente";
	}
	
	@RequestMapping(value="/utenti/register",method=RequestMethod.POST)
	public String signup(@ModelAttribute("utente") Utente utente,@ModelAttribute("credentials") Credentials credentials) {
		credentials.setUtente(utente);
		this.credentialService.saveCredential(credentials);
		return "utenti";	
	}

}
