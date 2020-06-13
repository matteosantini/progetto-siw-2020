package it.uniroma3.progetto2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.repository.ProjectRepository;
import it.uniroma3.progetto2020.repository.TaskRepository;
import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.service.ProjectService;
import it.uniroma3.progetto2020.service.TaskService;
import it.uniroma3.progetto2020.session.SessionData;

@Controller
public class TaskController {
	@Autowired
	private ProjectService progettoService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private TaskRepository taskRepository;
	
	@Autowired
	private ProjectRepository progettoRepository;
	
	@Autowired
	private SessionData session;
	
	@RequestMapping(value = "/view-prog/{id}", method = RequestMethod.GET)
	public String task(@PathVariable("id") long id, Model model) {
		Progetto p = progettoService.findProgetto(id);
		model.addAttribute("nomeprogetto", p.getNome());
		model.addAttribute("task", new Task());
		model.addAttribute("id_progetto",id);
		model.addAttribute("tasks", p.getTaskProgetto());
		return "tasks/task";
	}
	
	@RequestMapping(value = "/task-store", method = RequestMethod.POST)
	public String storeTask(Model model,@ModelAttribute("task") Task task, @ModelAttribute("id_progetto") Long id_p) {
		Progetto p = progettoService.findProgetto(id_p);
		task.setProgetto(p);
		task.setProrietario(session.getLoggedUser());
		taskService.saveTask(task);
		return "redirect:/view-prog/" + id_p;
	}
	
	@RequestMapping(value = "/mod-task/{id}", method = RequestMethod.GET)
	public String viewTaskForEdit(Model model,@PathVariable("id") Long id_task) {
		Task t = taskRepository.findById(id_task).get();
		model.addAttribute("taskmod",t);
		model.addAttribute("progetto_id", t.getProgetto().getId());
		return "tasks/mod-task";
	}
	
	@RequestMapping(value="/task-mod-send", method = RequestMethod.POST)
	public String saveTaskEdit(Model model, @ModelAttribute("taskmod") Task task, @RequestParam("id_progetto") Long id){
		Progetto p = progettoRepository.findById(id).get();
		task.setProgetto(p);
		taskRepository.save(task);
		return "redirect:/view-prog/" + task.getProgetto().getId();
	}
	
	@RequestMapping(value="/delete-task/{id}", method = RequestMethod.GET)
	public String deleteTask(Model model, @PathVariable("id") Long id){
		Task t = taskRepository.findById(id).get();
		Long id_progetto = t.getProgetto().getId();
		taskRepository.delete(t);
		return "redirect:/view-prog/" + id_progetto;
	}
	
}
