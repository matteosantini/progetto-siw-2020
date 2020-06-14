package it.uniroma3.progetto2020.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	@Transactional
	public void saveTask(Task task) {
		this.taskRepository.save(task);
	}

	@Override
	@Transactional
	public void deleteTask(Task task) {
		this.taskRepository.delete(task);
	}

	@Override
	@Transactional
	public Task getTaskById(Long id) {
		return this.taskRepository.findById(id).get();
	}
	
}
