package it.uniroma3.progetto2020.service;

import java.util.Optional;

import it.uniroma3.progetto2020.model.Utente;

public interface UtenteService {
	
	public Utente login(String username);
	public void iscrizione(Utente utente);
	public Optional<Utente> getUtenteById(Long id);
	public void editUtente(Utente utente);

}
