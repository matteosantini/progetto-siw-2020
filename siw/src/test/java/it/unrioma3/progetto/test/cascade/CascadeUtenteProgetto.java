package it.unrioma3.progetto.test.cascade;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
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
import it.uniroma3.progetto2020.model.Progetto;
import it.uniroma3.progetto2020.model.Utente;

class CascadeUtenteProgetto {

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
	public void createProgettoInCascade() throws Exception {
		Utente u=new Utente();
		u.setNome("prova 1");
		u.setCognome("prova 2");
		Progetto p=new Progetto();
		p.setNome("prova 1");
		p.setDatadiinizio(new Date());
		u.getProgettiPosseduti().add(p);
		p.setProprietario(u);
		tx.begin();
		em.persist(u);
		tx.commit();
		List<Progetto> progetti=em.createQuery("SELECT p FROM progetto p").getResultList();
		assertEquals(1, progetti.size());	
	}

	@Test
	public void deleteProgettoInCascade() throws Exception{
		Utente u=new Utente();
		u.setNome("prova 1");
		u.setCognome("prova 2");
		Progetto p=new Progetto();
		p.setNome("prova 1");
		p.setDatadiinizio(new Date());
		u.getProgettiPosseduti().add(p);
		p.setProprietario(u);
		tx.begin();
		em.persist(u);
		tx.commit();
		tx.begin();
		em.remove(u);
		tx.commit();
		List<Progetto> progetti=em.createQuery("SELECT p FROM progetto p").getResultList();
		assertEquals(0, progetti.size());	
	}

	@Test
	public void deleteUtenteInCascade() throws Exception{
		Utente u=new Utente();
		u.setNome("prova 1");
		u.setCognome("prova 2");
		Progetto p=new Progetto();
		p.setNome("prova 1");
		p.setDatadiinizio(new Date());
		u.getProgettiPosseduti().add(p);
		p.setProprietario(u);
		tx.begin();
		em.persist(u);
		tx.commit();
		tx.begin();
		em.remove(p);
		tx.commit();
		List<Utente> utenti=em.createQuery("SELECT u FROM utente u").getResultList();
		assertEquals(1, utenti.size());	
	}

	@Test
	public void deleteProgettoCondivisoCascade() throws Exception{
		Utente u=new Utente();
		u.setNome("prova 1");
		u.setCognome("prova 2");
		Progetto p=new Progetto();
		p.setNome("prova 1");
		p.setDatadiinizio(new Date());
		u.getProgettiAutorizzati().add(p);
		p.getUtentiAutorizzati().add(u);
		tx.begin();
		em.persist(u);
		em.persist(p);
		tx.commit();
		tx.begin();
		em.remove(u);
		tx.commit();
		List<Progetto> progetti=em.createQuery("SELECT p FROM progetto p").getResultList();
		assertEquals(1, progetti.size());	
	}

}
