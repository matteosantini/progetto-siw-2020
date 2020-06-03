package it.uniroma3.progetto2020.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.repository.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;


	@Override
	public Optional<Utente> getUtenteById(Long id) {
		return this.utenteRepository.findById(id);

	}

	@Override
	@Transactional
	public void saveUtente(Utente utente) {
		this.utenteRepository.save(utente);

	}

	@Override
	public Utente getUtenteByUsername(String username) {
		return this.utenteRepository.findByUsername(username);
	}

	@Override
	@Transactional
	public void deleteUtente(Long id) {
		this.utenteRepository.deleteById(id);
		
	}

	@Override
	public Iterable<Utente> getAllUtenti() {
		return this.utenteRepository.findAll();
	}

}
