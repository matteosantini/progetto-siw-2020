package it.uniroma3.progetto2020.repository;

import java.util.Date;
import java.util.List;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Task;
import it.uniroma3.progetto2020.model.Utente;

public interface ProjectRepository {
	
	public void creaProgetto(Progetto progetto);
	
	public List<Progetto> getProgettiByUtente(Long id);
	
	public List<Progetto> getProgettiCondivisi(Long id);
	
	public void editProgetto(Progetto progetto);
	
	public void deleteProgetto(Long id);
	
	public void aggiungiTag();
	
	public void condiviProgetto(Long id);
	
	}
