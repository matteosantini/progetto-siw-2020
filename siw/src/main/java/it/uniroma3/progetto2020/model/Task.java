package it.uniroma3.progetto2020.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	private String descrizione;
	
	private Date creazione;
	
	private String colore;
	
	@OneToOne
	private Utente prorietario;

	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Task(String nome, String descrizione, Date creazione, Utente prorietario,String colore) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.creazione = creazione;
		this.prorietario = prorietario;
		this.colore=colore;
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

	public Date getCreazione() {
		return creazione;
	}

	public void setCreazione(Date creazione) {
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