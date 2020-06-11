package it.uniroma3.progetto2020.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.repository.ProjectRepository;
import it.uniroma3.progetto2020.service.ProjectService;
import it.uniroma3.progetto2020.service.UtenteService;
import it.uniroma3.progetto2020.session.SessionData;

import org.springframework.web.bind.WebDataBinder;

@Controller
public class ProgettoController {

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//	sdf.setLenient(true);
//	binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
//	}
	
	@Autowired
	private ProjectService progettoService;
	
	@Autowired
	private SessionData session;
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping(value = "/progetti", method = RequestMethod.GET)
	public String progetto(Model model) {
		Utente u = this.session.getLoggedUser();
		model.addAttribute("progetto", new Progetto());
		model.addAttribute("progetti", u.getProgettiPosseduti());
		return "progetti/progetto";
	}
	
	@RequestMapping(value = "/progetti", method = RequestMethod.POST)
	public String submitProgetto(@ModelAttribute("progetto") Progetto progetto, Model model) {
		Utente u = this.session.getLoggedUser();
		progetto.setProprietario(u);
		this.session.getLoggedUser().getProgettiPosseduti().add(progetto);
		this.utenteService.saveUtente(this.session.getLoggedUser());
		return "redirect:/progetti";
	}
	
	@RequestMapping(value = "/mod-prog/{id}", method = RequestMethod.GET)
	public String editShowProgetto(@PathVariable("id") long id, Model model) {
		Progetto mod = this.progettoService.findProgetto(id).get();
		model.addAttribute("progettomod", mod);
		return "progetti/body-modal-mod-progetto";
	}
	
	@RequestMapping(value = "/delete-prog/{id}", method = RequestMethod.GET)
	public String deleteProgetto(@PathVariable("id") long id, Model model) {
		this.progettoService.deleteProgetto(id);
		return "redirect:/progetti";
	}
	
	@RequestMapping(value = "/progetti-mod-send/{id}", method = RequestMethod.POST)
	public String editProgetto(@ModelAttribute("progettomod") Progetto progetto, @PathVariable("id") long id, Model model) {
		progetto.setId(id);
		this.progettoService.saveProgetto(progetto);
		return "redirect:/progetti";
	}
	

	@PostMapping("/addProgetto")
	public String processForm(Progetto progetto) {

	    return "showMessage";
	}
}
