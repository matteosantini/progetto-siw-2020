package it.uniroma3.progetto2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.progetto2020.model.Commento;

import it.uniroma3.progetto2020.service.CommentoService;


@Controller
public class CommentoController {
	
	@Autowired
	private CommentoService commentoService;
	
	@RequestMapping("/commenti")
	public String getAllCommenti(Model model) {
		model.addAttribute("commenti", this.commentoService.getAllCommenti());
		return "commenti";
	}
	
	@RequestMapping(value="/commenti/add",method=RequestMethod.GET)
	public String addCommento(Model model) {
		model.addAttribute("commenti",new Commento());
		return "add Commento";
	}
	
	@RequestMapping(value="/commenti/add",method=RequestMethod.POST)
	public String processAddCommento(@ModelAttribute("commenti") Commento c) {
		this.commentoService.saveCommento(c);
		return "redirect:/commenti";
	}
	
	@RequestMapping(value="commenti/update/{id}",method=RequestMethod.GET)
	public String updateCommento(Model model,@PathVariable("id") Long id) {
		model.addAttribute("updateCommento",this.commentoService.getCommentoById(id) );
		return "updateCommento";
	}
	
	@RequestMapping(value="commenti/update",method=RequestMethod.POST)
	public String processUpdateCommento(@ModelAttribute("updateCommento") Commento c) {
		this.commentoService.saveCommento(c);
		return "redirect:/commenti";
	}
	
	@RequestMapping(value="commenti/delete/{id}",method=RequestMethod.GET)
	public String delete(Model model,@PathVariable("id") Long id) {
		model.addAttribute("deleteCommento", this.commentoService.getCommentoById(id));
		return "deleteCommento";
	}
	
	@RequestMapping(value="commenti/delete",method=RequestMethod.POST)
	public String processDelete(@ModelAttribute("deleteCommento") Commento c) {
		this.commentoService.deleteCommento(c);
		return "redirect:/commenti";
	}

}
