package it.uniroma3.progetto2020.service;

import it.uniroma3.progetto2020.model.Commento;
import it.uniroma3.progetto2020.model.Utente;

public interface CommentoService {
	
	public Iterable<Commento> getAllCommenti();
	public Utente getCommentoByUtente(Utente u);//forse ci va l'id
	public void saveCommento(Commento c);
	public Commento getCommentoById(Long id);
	public void deleteCommento(Commento c);

}
