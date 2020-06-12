package it.uniroma3.progetto2020.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progetto2020.model.Commento;
import it.uniroma3.progetto2020.model.Utente;

public interface CommentoRepository extends CrudRepository<Commento, Long>{
	
	public Utente findByUtente(Utente u);//forse ci va l'id o una query scritta a mano

}
