package it.uniroma3.progetto2020.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Tag;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Utente;

@Repository
public interface ProjectRepository extends CrudRepository<Progetto, Long>{
	
	
	public List<Progetto> findByProprietarioId(Long id);

	@Query("SELECT u FROM utente u left join u.progettiAutorizzati pu where pu.id IS NULL AND NOT u.id=?1")// WHERE NOT pu.id_progetto = ?1 ") 
	public List<Utente> getUtentiNonAutorizzati(Long id);
	
	@Query("SELECT t FROM tag t left join t.progetti tp where tp.id IS NULL")
	public List<Tag> getTagNonInseriti();
	
	@Query("SELECT t FROM tag t left join t.progetti tp where tp.id IS NOT NULL")
	public List<Tag> getTagInseriti();
	
	@Query("SELECT p FROM progetto p INNER JOIN p.utentiAutorizzati pu WHERE pu.id= ?1")
	public List<Progetto> getProgettiCondivisi(Long id_utente);
	
}