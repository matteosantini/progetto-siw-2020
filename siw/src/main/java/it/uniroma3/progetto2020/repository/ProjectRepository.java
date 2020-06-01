package it.uniroma3.progetto2020.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Utente;

public interface ProjectRepository extends CrudRepository<Progetto, Long>{
		
	}
