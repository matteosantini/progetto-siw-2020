package it.uniroma3.progetto2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.service.ProjectService;
import it.uniroma3.progetto2020.service.TaskService;

@Controller
public class TaskController {
	@Autowired
	private ProjectService progettoService;
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/view-prog/{id}", method = RequestMethod.GET)
	public String task(@PathVariable("id") long id, Model model) {
		Progetto p = progettoService.findProgetto(id);
		model.addAttribute("task", new Task());
		model.addAttribute("id_progetto",id);
		model.addAttribute("tasks", p.getTaskProgetto());
		return "tasks/task";
	}
	
	@RequestMapping(value = "/task-store", method = RequestMethod.POST)
	public String storeTask(Model model,@ModelAttribute("task") Task task, @ModelAttribute("id_progetto") Long id_p) {
		Progetto p = progettoService.findProgetto(id_p);
		task.setProgetto(p);
		taskService.saveTask(task);
		return "redirect:/view-prog/" + id_p;
	}
	
}
