package it.uniroma3.progetto2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.service.UtenteService;

@Controller
@RequestMapping("/utenti")
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	
	@RequestMapping
	public String allUtenti(Model model) {
		model.addAttribute("utenti",this.utenteService.getAllUtenti());
		return "utenti";
	}
	
	@RequestMapping("/utente={username}")
	public String getUtenteByUsername(Model model,@PathVariable("username") String username) {
		model.addAttribute("utente",this.utenteService.getUtenteByUsername(username));
		return "utente";
	}
	
	@RequestMapping(value="/update={id}",method=RequestMethod.GET)
	public String updateUtenteById(Model model,@PathVariable("id") Long id) {
		model.addAttribute("updateUtente", this.utenteService.getUtenteById(id).get());
		return "updateUtente";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String processUpdateUtenteById(@ModelAttribute("updateUtente") Utente utente) {
		this.utenteService.saveUtente(utente);
		return "utenti";
	}
	
	@RequestMapping(value="/delete={id}",method=RequestMethod.GET)
	public String delete(Model model,@PathVariable("id") Long id) {
		model.addAttribute("deleteUtente",id);
		return "deleteUtente";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String processDelete(@ModelAttribute("deleteUtente") Long id) {
		this.utenteService.deleteUtente(id);
		return "utenti";
	}

}
