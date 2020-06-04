package it.uniroma3.progetto2020.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Utente;

@Repository
public interface ProjectRepository extends CrudRepository<Progetto, Long>{
		
}