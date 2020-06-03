package it.uniroma3.progetto2020.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Credentials;
import it.uniroma3.progetto2020.repository.CredentialsRepository;

@Service
public class CredentialsServiceImpl implements CredentialService {
	
	@Autowired
	private CredentialsRepository credentialsRepository;

	@Override
	public Credentials getCredentials(long id) {
		return this.credentialsRepository.findById(id).get();
	}

	@Override
	public Credentials getCredentials(String username) {
		return this.credentialsRepository.findByUsername(username).get();
	}

	@Override
	@Transactional
	public void saveCredential(Credentials credentials) {
		this.credentialsRepository.save(credentials);

	}

}
