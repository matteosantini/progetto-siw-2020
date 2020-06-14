package it.uniroma3.progetto2020.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	private String descrizione;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime creazione;
	
	private String colore;
	
	@OneToOne
	private Utente prorietario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Progetto progettotask;
	
	@ManyToMany(mappedBy="tasks", cascade=CascadeType.PERSIST)
	private List<Tag> tags;
	
	@OneToMany(mappedBy="task",cascade=CascadeType.REMOVE)
	private List<Commento> commenti;
	
	public Task() {
		super();
		this.creazione=LocalDateTime.now();
		this.tags=new ArrayList<Tag>();
		this.commenti=new ArrayList<Commento>();
	}

	public Task(String nome, String descrizione, Date creazione, Utente prorietario,String colore) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.prorietario = prorietario;
		this.colore=colore;
		this.creazione=LocalDateTime.now();
	}

	public Long getId() {
		return id;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDateTime getCreazione() {
		return creazione;
	}

	public void setCreazione(LocalDateTime creazione) {
		this.creazione = creazione;
	}

	public Utente getProrietario() {
		return prorietario;
	}

	public void setProrietario(Utente prorietario) {
		this.prorietario = prorietario;
	}
	
	public void setColore(String colore) {
		this.colore=colore;
	}
	
	public String getColore() {
		return this.colore;
	}
	
	public void setProgetto(Progetto p){
		this.progettotask = p;
	}
	
	public Progetto getProgetto() {
		return this.progettotask;
	} 
	
	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creazione == null) ? 0 : creazione.hashCode());
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((prorietario == null) ? 0 : prorietario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Task other = (Task) obj;
		if (creazione == null) {
			if (other.creazione != null)
				return false;
		} else if (!creazione.equals(other.creazione))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (prorietario == null) {
			if (other.prorietario != null)
				return false;
		} else if (!prorietario.equals(other.prorietario))
			return false;
		return true;
	}
	
	

}
