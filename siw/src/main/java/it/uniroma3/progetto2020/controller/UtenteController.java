package it.uniroma3.progetto2020.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.progetto2020.model.Credentials;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.service.CredentialService;
import it.uniroma3.progetto2020.service.UtenteService;
import it.uniroma3.progetto2020.session.SessionData;

@Controller
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private CredentialService credentialService;
	
	@Autowired
	private SessionData session;
	
	
	@RequestMapping("/utente/me")
	public String myProfile(Model model) {
		model.addAttribute("ruolo", this.session.getLoggedCredentials().getRole());
		model.addAttribute("utente",this.utenteService.getUtenteById(this.session.getLoggedUser().getId()).get());
		return "utenti/utente";
	}
	@RequestMapping("/utenti")
	public String allUtenti(Model model) {
		model.addAttribute("utenti",this.utenteService.getAllUtenti());
		return "utenti/utenti";
	}
	
	@RequestMapping("/utente/{id}")
	public String getUtenteByUsername(Model model,@PathVariable Long id) {
		model.addAttribute("utente",this.utenteService.getUtenteById(id).get());
		return "utenti/utente";
	}
	
	@RequestMapping(value="/utenti/update/{id}",method=RequestMethod.GET)
	public String updateUtenteById(Model model,@PathVariable("id") Long id) {
		model.addAttribute("credenziali", this.utenteService.getUtenteById(id).get().getCredentials());
		model.addAttribute("utente", this.utenteService.getUtenteById(id).get());
		return "utenti/updateUtente";
	}
	
	@RequestMapping(value="/utenti/update",method=RequestMethod.POST)
	public String processUpdateUtenteById(@ModelAttribute("updateUtente") Utente utente, @ModelAttribute("credenziali") Credentials c) {
		utente.setModifica(LocalDateTime.now());
		this.utenteService.saveUtente(utente);
		return "redirect:/";
	}
	
	@RequestMapping(value="/utenti/delete/{id}")
	public String delete(Model model,@PathVariable("id") Long id) {
		if(!id.equals(this.session.getLoggedUser().getId()))
		this.utenteService.deleteUtente(id);
		return "redirect:/utenti";
	}

}
