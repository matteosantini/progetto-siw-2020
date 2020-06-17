package it.uniroma3.progetto2020.service;

import java.util.List;
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
	@Transactional
	public void deleteUtente(Long id) {
		this.utenteRepository.deleteById(id);
		
	}

	@Override
	public List<Utente> getAllUtenti(Long id) {
		return this.utenteRepository.findAll(id);
	}

}
