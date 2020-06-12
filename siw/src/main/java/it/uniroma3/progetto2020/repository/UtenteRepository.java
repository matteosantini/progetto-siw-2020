package it.uniroma3.progetto2020.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progetto2020.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente,Long> {
	
	public Optional<Utente> findById(Long id);

	

}
