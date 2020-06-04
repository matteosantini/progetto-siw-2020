package it.uniroma3.progetto2020.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.repository.ProjectRepository;
import it.uniroma3.progetto2020.service.ProjectService;

@Controller
public class ProgettoController {

	@Autowired
	private ProjectService progettoService;
	
	@RequestMapping(value = "/progetto", method = RequestMethod.GET)
	public String progetto(Model model) {
		model.addAttribute("progetto", new Progetto());
		model.addAttribute("progetti", this.progettoService.getAllProgetto());
		return "progetto";
	}
	
	@RequestMapping(value = "/progetto", method = RequestMethod.POST)
	public String submitProgetto(@ModelAttribute("progetto") Progetto progetto) {
		progettoService.saveProgetto(progetto);
		return "progetto";
	}
	
	@PostMapping("/addProgetto")
	public String processForm(Progetto progetto) {

	    return "showMessage";
	}
}
