package it.uniroma3.progetto2020.session;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import it.uniroma3.progetto2020.model.Credentials;
import it.uniroma3.progetto2020.model.Utente;
import it.uniroma3.progetto2020.repository.CredentialsRepository;

/**
 * SessionData is an interface to save and retrieve specific objects from the current Session.
 * It is mainly used to store the currently logged User and her Credentials
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionData {

    /**
     * Currently logged User
     */
    private Utente user;

    /**
     * Credentials for the currently logged User
     */
    private Credentials credentials;

    @Autowired
    private CredentialsRepository credentialsRepository;

    /**
     * Retrieve from Session the credentials for the currently logged user.
     * If they are not stored in Session already, retrieve them from the SecurityContext and from the DB
     * and store them in session.
     *
     * @return the retrieved Credentials for the currently logged user
     */
    public Credentials getLoggedCredentials() {
        if (this.credentials == null)
            this.update();
        return this.credentials;
    }

    /**
     * Retrieve from Session the currently logged User.
     * If it is not stored in Session already, retrieve it from the DB and store it in session.
     *
     * @return the retrieved Credentials for the currently logged user
     */
    public Utente getLoggedUser() {
        if (this.user == null)
            this.update();
        return this.user;
    }

    /**
     * Store the Credentials and User objects for the currently logged user in Session
     */
    private void update() {
        UserDetails loggedUserDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.credentials = this.credentialsRepository.findByUsername(loggedUserDetails.getUsername()).get(); // can never be absent
        this.credentials.setPassword("[PROTECTED]");
        this.user = this.credentials.getUtente();
    }
}