package it.uniroma3.progetto2020.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.progetto2020.model.CustomDateEditor;
import it.uniroma3.progetto2020.model.InitBinder;
import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.SimpleDateFormat;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.repository.ProjectRepository;
import it.uniroma3.progetto2020.service.ProjectService;
import org.springframework.web.bind.WebDataBinder;

@Controller
public class ProgettoController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	sdf.setLenient(true);
	binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	@Autowired
	private ProjectService progettoService;
	
	@RequestMapping(value = "/progetto", method = RequestMethod.GET)
	public String progetto(Model model) {
		model.addAttribute("progetto", new Progetto());
		model.addAttribute("progetti", this.progettoService.getAllProgetto());
		return "progetto";
	}
	
	@RequestMapping(value = "/progetto", method = RequestMethod.POST)
	public String submitProgetto(@ModelAttribute("progetto") Progetto progetto, Model model) {
		progettoService.saveProgetto(progetto);
		model.addAttribute("progetti", this.progettoService.getAllProgetto());
		return "progetto";
	}
	
	@PostMapping("/addProgetto")
	public String processForm(Progetto progetto) {

	    return "showMessage";
	}
}
