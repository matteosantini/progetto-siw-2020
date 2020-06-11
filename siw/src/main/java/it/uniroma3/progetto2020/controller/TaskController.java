package it.uniroma3.progetto2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.service.ProjectService;

@Controller
public class TaskController {
	@Autowired
	private ProjectService progettoService;
	
	@RequestMapping(value = "/view-prog/{id}", method = RequestMethod.GET)
	public String task(@PathVariable("id") long id, Model model) {
		Progetto p = progettoService.findProgetto(id);
		model.addAttribute("task", new Task());
		model.addAttribute("tasks", p.getTaskProgetto());
		return "tasks/task";
	}
	
}
