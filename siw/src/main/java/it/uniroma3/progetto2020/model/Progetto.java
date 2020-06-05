package it.uniroma3.progetto2020.model;



import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;


@Entity
public class Progetto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String nome;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datadiinizio;
	
	@OneToMany
	private List<Task> taskProgetto;
	
	@ManyToOne
	private Utente proprietario;	
	
	@ManyToMany
	private List<Utente> utentiAutorizzati;

	public Progetto(String nome, Date datadiinizio, List<Task> taskProgetto, Utente proprietario,
			List<Utente> utentiautorizzati) {
		super();
		this.nome = nome;
		this.datadiinizio = datadiinizio;
		this.taskProgetto = taskProgetto;
		this.proprietario = proprietario;
		this.utentiAutorizzati = utentiautorizzati;
	}

	public Progetto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return this.id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDatadiinizio() {
		return datadiinizio;
	}

	public void setDatadiinizio(Date datadiinizio) {
		this.datadiinizio = datadiinizio;
	}

	public Utente getProprietario() {
		return proprietario;
	}

	public void setProprietario(Utente proprietario) {
		this.proprietario = proprietario;
	}

	public List<Task> getTaskProgetto() {
		return taskProgetto;
	}

	public void setTaskProgetto(List<Task> taskProgetto) {
		this.taskProgetto = taskProgetto;
	}

	public List<Utente> getUtentiautorizzati() {
		return utentiAutorizzati;
	}

	public void setUtentiautorizzati(List<Utente> utentiautorizzati) {
		this.utentiAutorizzati = utentiautorizzati;
	}	
	
}
