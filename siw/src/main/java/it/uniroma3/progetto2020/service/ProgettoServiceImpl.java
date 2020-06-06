package it.uniroma3.progetto2020.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Progetto;
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
	public Optional<Progetto> findProgetto(Long id) {
		return this.progettoRepository.findById(id);
	}
	
	@Override
	@Transactional
	public void editProgetto(Long id, String nome) {
		progettoRepository.updateProgetto(id, nome);
	}

	
	@Override
	public List<Progetto> getProgettiByUtente(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Progetto> getProgettiCondivisi(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProgetto(Long id) {
		// TODO Auto-generated method stub

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
	public <S extends Progetto> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Progetto> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Progetto> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Progetto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Progetto> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Progetto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Progetto> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
