package it.uniroma3.progetto2020.repository;

import java.util.Date;
import java.util.List;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Utente;

public interface ProjectRepository {
	
	public void creaProgetto(String nome, Date datadiinizio, List<Task> taskProgetto, Utente proprietario,
			List<Utente> utentiautorizzati);
	
	public List<Progetto> getProgettiByUtente(Long id);
	
	public List<Progetto> getProgettiCondivisi(Long id);
	
	public void editProgetto(Long id, String nome, Date datadiinizio, List<Task> taskProgetto, Utente proprietario,
			List<Utente> utentiautorizzati);
	
	public void deleteProgetto(Long id);
	
	public void aggiungiTag();
	
	public void condiviProgetto(Long id);
	
	}
