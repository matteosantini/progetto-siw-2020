package it.uniroma3.progetto2020.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Tag;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.repository.ProjectRepository;
import it.uniroma3.progetto2020.repository.UtenteRepository;

@Service
public class ProgettoServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository progettoRepository;
	
	@Override
	@Transactional
	public void saveProgetto(Progetto progetto) {
		this.progettoRepository.save(progetto);
	}
	
	@Override
	public Iterable<Progetto> getAllProgetto() {
		return this.progettoRepository.findAll();
	}
	
	@Override
	public Progetto findProgetto(Long id) {
		return this.progettoRepository.findById(id).get();
	}
	
	@Override
	@Transactional
	public void deleteProgetto(Long id) {
		Progetto p = this.progettoRepository.findById(id).get();
		this.progettoRepository.delete(p);
		return;
	}

	
	@Override
	public List<Progetto> getProgettiByUtente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Progetto> getProgettiCondivisi(Long id) {
		return this.progettoRepository.getProgettiCondivisi(id);
	}

	@Override
	public void aggiungiTag() {
		// TODO Auto-generated method stub

	}

	@Override
	public void condiviProgetto(Long id) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Progetto> getByProprietario(Long idProprietario) {
		return this.progettoRepository.findByProprietarioId(idProprietario);
	}

	@Override
	public List<Utente> getUtentiProgettoNonAutorizzati() {
		return this.progettoRepository.getUtentiNonAutorizzati();
	}
	
	@Override
	public List<Tag> getTagNonInseriti(){
		return this.progettoRepository.getTagNonInseriti();
	}

	@Override
	public List<Tag> getTagInseriti() {
		return this.progettoRepository.getTagInseriti();
	}
}
