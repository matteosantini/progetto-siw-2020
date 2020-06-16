package it.unrioma3.progetto.test.cascade;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.progetto2020.model.Credentials;
import it.uniroma3.progetto2020.model.Utente;

class CascadeCredentialsUtente {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction tx;
	
	
	@BeforeAll
	public static void initEntityManager() throws Exception {
		emf = Persistence.createEntityManagerFactory("progettosiw-unit-test");
		em = emf.createEntityManager();
	}
	@AfterAll
	public static void closeEntityManager() throws SQLException {
		if (em != null) em.close();
		if (emf != null) emf.close();
	}
	@BeforeEach
	public void initTransaction() {
		emf = Persistence.createEntityManagerFactory("progettosiw-unit-test");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}
	
	@Test
	public void createUtenteInCascade() throws Exception {
		Utente u=new Utente();
		u.setNome("prova 1");
		u.setCognome("prova 2");
		Credentials c=new Credentials();
		c.setUsername("prova1");
		c.setPassword("prova1");
		c.setRole("ADMIN");
		c.setUtente(u);
		u.setCredentials(c);
		tx.begin();
		em.persist(c);
		tx.commit();
		List<Utente> utenti=em.createQuery("SELECT u FROM utente u").getResultList();
		assertEquals(1, utenti.size());	
	}
	
	@Test
	public void deleteUtenteInCascade() throws Exception{
		Utente u=new Utente();
		u.setNome("prova 1");
		u.setCognome("prova 2");
		Credentials c=new Credentials();
		c.setUsername("prova1");
		c.setPassword("prova1");
		c.setRole("ADMIN");
		c.setUtente(u);
		u.setCredentials(c);
		tx.begin();
		em.persist(c);
		tx.commit();
		tx.begin();
		em.remove(c);
		tx.commit();
		List<Utente> utenti=em.createQuery("SELECT u FROM utente u").getResultList();
		assertEquals(0, utenti.size());
	}
	
	@Test
	public void deleteCredentialsInCascade() throws Exception{
		Utente u=new Utente();
		u.setNome("prova 1");
		u.setCognome("prova 2");
		Credentials c=new Credentials();
		c.setUsername("prova1");
		c.setPassword("prova1");
		c.setRole("ADMIN");
		c.setUtente(u);
		u.setCredentials(c);
		tx.begin();
		em.persist(c);
		tx.commit();
		tx.begin();
		em.remove(u);
		tx.commit();
		tx.begin();
		em.persist(new Utente());
		tx.commit();
		List<Credentials> credentials=em.createQuery("SELECT c FROM credentials c").getResultList();
		assertEquals(0, credentials.size());
	}

}
