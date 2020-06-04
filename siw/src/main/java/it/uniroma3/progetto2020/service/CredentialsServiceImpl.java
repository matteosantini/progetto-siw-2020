package it.uniroma3.progetto2020.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.progetto2020.model.Credentials;
import it.uniroma3.progetto2020.repository.CredentialsRepository;

@Service
public class CredentialsServiceImpl implements CredentialService {
	
	@Autowired
	private CredentialsRepository credentialsRepository;
	
	@Autowired
	private  PasswordEncoder passwordEncoder;

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
		credentials.setRole(Credentials.DEFAULT_ROLE);
		credentials.setPassword(this.passwordEncoder.encode(credentials.getPassword()));
		this.credentialsRepository.save(credentials);

	}

}
