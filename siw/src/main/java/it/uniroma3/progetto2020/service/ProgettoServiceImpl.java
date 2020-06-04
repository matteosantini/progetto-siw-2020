package it.uniroma3.progetto2020.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Progetto;

@Service
public class ProgettoServiceImpl implements ProjectService {

	@Override
	public void creaProgetto(Progetto progetto) {
		// TODO Auto-generated method stub

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
	public void editProgetto(Progetto progetto) {
		// TODO Auto-generated method stub

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
