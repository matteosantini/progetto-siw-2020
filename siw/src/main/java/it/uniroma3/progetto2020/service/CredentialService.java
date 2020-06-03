package it.uniroma3.progetto2020.service;

import it.uniroma3.progetto2020.model.Credentials;

public interface CredentialService {
	
	public Credentials getCredentials(long id);
	public Credentials getCredentials(String username);
	public void saveCredential(Credentials credentials);

}
