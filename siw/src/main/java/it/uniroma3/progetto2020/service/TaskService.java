package it.uniroma3.progetto2020.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Tag;
import it.uniroma3.progetto2020.model.Task;

@Service
public interface TaskService {

	void saveTask(Task task);
	void deleteTask(Task task);
	public Task getTaskById(Long id);
	public List<Tag> getTagNonInseriti();
}
