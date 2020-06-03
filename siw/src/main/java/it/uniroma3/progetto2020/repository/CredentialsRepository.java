package it.uniroma3.progetto2020.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progetto2020.model.Credentials;

public interface CredentialsRepository extends CrudRepository<Credentials,Long>{
	
	public Optional<Credentials> findByUsername(String username);
 
}
