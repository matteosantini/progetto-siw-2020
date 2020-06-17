package it.uniroma3.progetto2020.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progetto2020.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente,Long> {
	
	public Optional<Utente> findById(Long id);

	@Query("SELECT u FROM utente u WHERE NOT u.id= ?1")
	public List<Utente> findAll(Long id);

	

}
