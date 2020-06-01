package it.uniroma3.progetto2020.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.repository.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;

	@Override
	public Utente login(String username) {
		return utenteRepository.findByUsername(username);
	}

	@Override
	public void iscrizione(Utente utente) {
		this.utenteRepository.save(utente);

	}

	@Override
	public Optional<Utente> getUtenteById(Long id) {
		return this.utenteRepository.findById(id);

	}

	@Override
	public void editUtente(Utente utente) {
		this.utenteRepository.save(utente);

	}

}
