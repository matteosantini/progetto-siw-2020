package it.uniroma3.progetto2020.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Utente;

@Repository
public interface ProjectRepository extends CrudRepository<Progetto, Long>{
	
	
	public List<Progetto> findByProprietarioId(Long id);

	//@Query("SELECT u FROM utente u JOIN utentiprogetti pu ON u.id = pu.utente_id WHERE NOT pu.progetti_autorizzati_id = ?1 ") //
	//public List<Utente> getUtentiNonAutorizzati(Long id);
}
