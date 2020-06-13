package it.uniroma3.progetto2020.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Utente;

public interface ProjectService{
	public void saveProgetto(Progetto progetto);
	public Progetto findProgetto(Long id);
	public List<Progetto> getProgettiByUtente(Long id);
	public List<Progetto> getProgettiCondivisi(Long id);
	public void deleteProgetto(Long id);
	public void aggiungiTag();
	public void condiviProgetto(Long id);
	public Iterable<Progetto> getAllProgetto();
	public List<Progetto> getByProprietario(Long idProprietario);
	//public List<Utente> getUtentiProgettoNonAutorizzati();
}
