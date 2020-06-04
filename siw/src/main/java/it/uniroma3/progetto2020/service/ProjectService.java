package it.uniroma3.progetto2020.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.progetto2020.model.Progetto;

public interface ProjectService{
	public void saveProgetto(Progetto progetto);
	public List<Progetto> getProgettiByUtente(Long id);
	public List<Progetto> getProgettiCondivisi(Long id);
	public void editProgetto(Progetto progetto);
	public void deleteProgetto(Long id);
	public void aggiungiTag();
	public void condiviProgetto(Long id);
}
