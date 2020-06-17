package it.uniroma3.progetto2020.service;

import java.util.List;
import java.util.Optional;

import it.uniroma3.progetto2020.model.Utente;

public interface UtenteService {
	
	public Optional<Utente> getUtenteById(Long id);
	public void saveUtente(Utente utente);
	public void deleteUtente(Long id);
	public List<Utente> getAllUtenti(Long long1);
}
