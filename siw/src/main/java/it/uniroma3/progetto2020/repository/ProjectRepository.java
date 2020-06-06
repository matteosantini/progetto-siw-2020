package it.uniroma3.progetto2020.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Utente;

@Repository
public interface ProjectRepository extends CrudRepository<Progetto, Long>{
	
	@Query("update Progetto p set p.nome = :nome WHERE p.id = :id")
    void updateProgetto(@Param("id") Long id, @Param("nome") String nome);
}
