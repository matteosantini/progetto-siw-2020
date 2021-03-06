package it.uniroma3.progetto2020.controller;

import java.util.Date;
import java.util.List;
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
import it.uniroma3.progetto2020.model.Tag;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.repository.ProjectRepository;
import it.uniroma3.progetto2020.service.ProjectService;
import it.uniroma3.progetto2020.service.TagService;
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
	
	@Autowired
	private TagService tagService;
	
	private Progetto progettoCorrente;

	@RequestMapping(value = "/progetti", method = RequestMethod.GET)
	public String progetto(Model model) {
		Utente u = this.session.getLoggedUser();
		model.addAttribute("progetto", new Progetto());
		model.addAttribute("progetti", this.progettoService.getByProprietario(u.getId()));
		model.addAttribute("progetti_condivisi", this.progettoService.getProgettiCondivisi(u.getId()));
		return "progetti/progetto";
	}

	@RequestMapping(value = "/progetti", method = RequestMethod.POST)
	public String submitProgetto(@ModelAttribute("progetto") Progetto progetto, Model model) {
		
		Utente u = this.utenteService.getUtenteById(this.session.getLoggedUser().getId()).get();
		progetto.setProprietario(u);
		u.getProgettiPosseduti().add(progetto);
		this.utenteService.saveUtente(u);
		return "redirect:/progetti";
	}

	@RequestMapping(value = "/mod-prog/{id}", method = RequestMethod.GET)
	public String editShowProgetto(@PathVariable("id") Long id, Model model) {
		Progetto mod = this.progettoService.findProgetto(id);
		model.addAttribute("progettomod", mod);
		return "progetti/body-modal-mod-progetto";
	}

	@RequestMapping(value = "/delete-prog/{id}", method = RequestMethod.GET)
	public String deleteProgetto(@PathVariable("id") Long id, Model model) {
		Progetto p = this.progettoService.findProgetto(id);
		this.progettoService.deleteProgetto(id);
		Utente u = this.session.getLoggedUser();
		u.getProgettiPosseduti().remove(p);
		return "redirect:/progetti";
	}

	@RequestMapping(value = "/progetti-mod-send/{id}", method = RequestMethod.POST)
	public String editProgetto(@ModelAttribute("progettomod") Progetto progetto, @PathVariable("id") Long id, Model model) {
		Progetto p = this.progettoService.findProgetto(id);
		p.setNome(progetto.getNome());
		p.setDatadiinizio(progetto.getDatadiinizio());
		//progetto.setProprietario(this.session.getLoggedUser());
		this.progettoService.saveProgetto(p);
		return "redirect:/progetti";
	}
	
//	@RequestMapping(value="/progetti-share-send/{id}",method=RequestMethod.POST)     
//	public String shareProgetto(@ModelAttribute("progettoshare") Progetto progetto,@ModelAttribute("idUtente") Long idUtente) {  
//		//bisogna mettere sulla pagina la lista di tutti gli utenti a cui Ã¨ possibile condividere il progetto         
//		//e bisogna fare una if che controlla che non sia giÃ  autorizzato (perÃ² si potrebbe fare un controllo anche qui e         
//		//shallona         Utente u=this.utenteService.getUtenteById(idUtente).get();         
//		progetto.getUtentiautorizzati().add(u);         
//		u.getProgettiAutorizzati().add(progetto);         
//		return "redirect/progetti";     
//		
//	}

	
	@RequestMapping(value="/share-prog/{id}", method= RequestMethod.GET)
	public String shareShowProgetto(Model model,@PathVariable("id") Long id) {
		this.progettoCorrente=this.progettoService.findProgetto(id);
		List<Utente> utentiNonAutorizzati=this.progettoService.getUtentiProgettoNonAutorizzati(this.session.getLoggedUser().getId());
		//utentiNonAutorizzati.remove(this.progettoCorrente.getProprietario());
		model.addAttribute("utenti",utentiNonAutorizzati);
		return "progetti/progetto-share-send";
	}
	
	@RequestMapping(value="/add-user-project/{id}",method=RequestMethod.GET)
	public String addUtenteToProgetto(@PathVariable("id") Long id_utente) {
		Utente u = this.utenteService.getUtenteById(id_utente).get();
		u.getProgettiAutorizzati().add(this.progettoCorrente);
		this.progettoCorrente.getUtentiAutorizzati().add(u);
		this.utenteService.saveUtente(u);
		this.progettoService.saveProgetto(this.progettoCorrente);
		return "redirect:/share-prog/"+this.progettoCorrente.getId();
	}
	
	@RequestMapping(value="/tag-prog/{id}",method=RequestMethod.GET)
	public String viewTagProgetto(@PathVariable("id") Long id_progetto, Model model) {
		model.addAttribute("tags",this.progettoService.getTagNonInseriti());
		this.progettoCorrente=this.progettoService.findProgetto(id_progetto);
		return "tag/tag-prog";
	}
	
	@RequestMapping(value="/add-tag-prog/{id}",method=RequestMethod.GET)
	public String addTagToProgetto(@PathVariable("id") Long id_tag, Model model) {
		Tag t = this.tagService.getTagById(id_tag);
		t.getProgetti().add(this.progettoCorrente);
		this.progettoCorrente.getTags().add(t);
		this.progettoService.saveProgetto(this.progettoCorrente);
		this.tagService.saveTag(t);
		return "redirect:/tag-prog/"+ this.progettoCorrente.getId();
	}
}
