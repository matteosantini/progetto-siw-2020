package it.uniroma3.progetto2020.service;

import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Task;

@Service
public interface TaskService {

	void saveTask(Task task);

}
