package it.uniroma3.progetto2020.model;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@OneToMany(mappedBy = "progettotask", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Task> taskProgetto;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Utente proprietario;	
	
	@ManyToMany
	private List<Utente> utentiAutorizzati;
	
	@ManyToMany(mappedBy="progetti",cascade=CascadeType.PERSIST)
	private List<Tag> tags;

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
		this.taskProgetto=new ArrayList<Task>();
		this.utentiAutorizzati=new ArrayList<Utente>();
		this.tags=new ArrayList<Tag>();
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		 this.id = id;
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

	public List<Utente> getUtentiAutorizzati() {
		return utentiAutorizzati;
	}

	public void setUtentiautorizzati(List<Utente> utentiautorizzati) {
		this.utentiAutorizzati = utentiautorizzati;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}	
	
	
	
}
