package it.uniroma3.progetto2020.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progetto2020.model.Tag;
import it.uniroma3.progetto2020.model.Task;

public interface TaskRepository extends CrudRepository<Task, Long>{

	@Query("SELECT t FROM tag t LEFT JOIN t.tasks tt INNER JOIN t.progetti tp WHERE tt IS NULL")
	public List<Tag> getTagNonInseriti();
}
