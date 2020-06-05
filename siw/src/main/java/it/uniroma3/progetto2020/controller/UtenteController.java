package it.uniroma3.progetto2020.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.service.UtenteService;
import it.uniroma3.progetto2020.session.SessionData;

@Controller
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private SessionData session;
	
	
	@RequestMapping("/utenti")
	public String allUtenti(Model model) {
		model.addAttribute("utenti",this.utenteService.getAllUtenti());
		return "utenti";
	}
	
	@RequestMapping("/utente")
	public String getUtenteByUsername(Model model) {
		model.addAttribute("utente",this.session.getLoggedUser());
		model.addAttribute("credentials", this.session.getLoggedCredentials());
		return "utente";
	}
	
	@RequestMapping(value="/utenti/update/{id}",method=RequestMethod.GET)
	public String updateUtenteById(Model model,@PathVariable("id") Long id) {
		model.addAttribute("utente", this.utenteService.getUtenteById(id).get());
		return "updateUtente";
	}
	
	@RequestMapping(value="/utenti/update/{id}",method=RequestMethod.POST)
	public String processUpdateUtenteById(@ModelAttribute("updateUtente") Utente utente) {
		utente.setModifica(LocalDateTime.now());
		this.utenteService.saveUtente(utente);
		return "redirect:/utente";
	}
	
	@RequestMapping(value="/utenti/delete={id}",method=RequestMethod.GET)
	public String delete(Model model,@PathVariable("id") Long id) {
		model.addAttribute("deleteUtente",id);
		return "deleteUtente";
	}
	
	@RequestMapping(value="/utenti/delete",method=RequestMethod.POST)
	public String processDelete(@ModelAttribute("deleteUtente") Long id) {
		this.utenteService.deleteUtente(id);
		return "utenti";
	}

}
