package it.uniroma3.progetto2020.model;



import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String username;

	@Transient
	private String password;

	private String nome;
	private String cognome;
	private Date creazione;

	@OneToMany(mappedBy="proprietario")
	private List<Progetto> progettiPosseduti;

	@ManyToMany(mappedBy="utentiAutorizzati")
	private List<Progetto> progettiAutorizzati;

	public Utente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utente(String username, String password, String nome, String cognome, Date creazione,
			List<Progetto> progettiPosseduti, List<Progetto> progettiAutorizzati) {
		super();
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.creazione = creazione;
		this.progettiPosseduti = progettiPosseduti;
		this.progettiAutorizzati = progettiAutorizzati;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getCreazione() {
		return creazione;
	}

	public void setCreazione(Date creazione) {
		this.creazione = creazione;
	}

	public List<Progetto> getProgettiPosseduti() {
		return progettiPosseduti;
	}

	public void setProgettiPosseduti(List<Progetto> progettiPosseduti) {
		this.progettiPosseduti = progettiPosseduti;
	}

	public List<Progetto> getProgettiAutorizzati() {
		return progettiAutorizzati;
	}

	public void setProgettiAutorizzati(List<Progetto> progettiAutorizzati) {
		this.progettiAutorizzati = progettiAutorizzati;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((creazione == null) ? 0 : creazione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((progettiAutorizzati == null) ? 0 : progettiAutorizzati.hashCode());
		result = prime * result + ((progettiPosseduti == null) ? 0 : progettiPosseduti.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Utente other = (Utente) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (creazione == null) {
			if (other.creazione != null)
				return false;
		} else if (!creazione.equals(other.creazione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (progettiAutorizzati == null) {
			if (other.progettiAutorizzati != null)
				return false;
		} else if (!progettiAutorizzati.equals(other.progettiAutorizzati))
			return false;
		if (progettiPosseduti == null) {
			if (other.progettiPosseduti != null)
				return false;
		} else if (!progettiPosseduti.equals(other.progettiPosseduti))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}





}
