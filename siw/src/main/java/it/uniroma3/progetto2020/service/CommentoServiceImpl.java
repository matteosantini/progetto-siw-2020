package it.uniroma3.progetto2020.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Commento;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.repository.CommentoRepository;

@Service
public class CommentoServiceImpl implements CommentoService{
	
	@Autowired
	private CommentoRepository commentoRepository;

	@Override
	public Iterable<Commento> getAllCommenti() {
		return this.commentoRepository.findAll();
	}

	@Override
	public Utente getCommentoByUtente(Utente u) {
		return this.commentoRepository.findByAutoreId(u.getId());
	}

	@Override
	public void saveCommento(Commento c) {
		this.commentoRepository.save(c);
	}

	@Override
	public Commento getCommentoById(Long id) {
		return this.commentoRepository.findById(id).get();
	}

	@Override
	public void deleteCommento(Commento c) {
		this.commentoRepository.delete(c);
	}
	
	

}
