package it.uniroma3.progetto2020.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progetto2020.model.Tag;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Utente;

public interface TaskRepository extends CrudRepository<Task, Long>{

	@Query("SELECT t FROM tag t LEFT JOIN t.tasks tt INNER JOIN t.progetti tp WHERE tt IS NULL")
	public List<Tag> getTagNonInseriti();
	
	@Query("SELECT u FROM utente u LEFT JOIN u.tasks ut INNER JOIN u.progettiAutorizzati up WHERE ut IS NULL AND NOT u.id= ?1")
	public List<Utente> getUtentiInseriti(Long id);
	
	@Query("SELECT t FROM task t INNER JOIN t.utenti tu WHERE t.progettotask.id = ?1 AND tu.id = ?2")
	public List<Task> tasksProgettoCondiviso(Long id_progetto, Long id_utente);
}
