package it.uniroma3.progetto2020.model;



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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name="utente")
public class Utente {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	private String nome;
	private String cognome;
	private LocalDateTime creazione;
	private LocalDateTime modifica;

	@OneToMany(mappedBy="proprietario",cascade= CascadeType.ALL)
	private List<Progetto> progettiPosseduti;

	@ManyToMany (cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	@JoinTable(name="utentiprogetti", joinColumns=@JoinColumn(name="utente_id"),inverseJoinColumns = @JoinColumn(name="progetto_id"))
	private List<Progetto> progettiAutorizzati;
	
	@OneToMany(mappedBy="autore",cascade=CascadeType.ALL)
	private List<Commento> commenti;
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
	private Credentials credentials;
	
	@ManyToMany
	@JoinTable(name="utentitasks", joinColumns=@JoinColumn(name="utente_id"),inverseJoinColumns = @JoinColumn(name="task_id"))
	private List<Task> tasks;

	public Utente() {
		super();
		this.creazione=LocalDateTime.now();
		this.modifica=LocalDateTime.now();
		this.progettiAutorizzati=new ArrayList<Progetto>();
		this.progettiPosseduti=new ArrayList<Progetto>();
		this.commenti=new ArrayList<Commento>();
		this.tasks=new ArrayList<Task>();
		
	}

	public Utente(String nome, String cognome,
			List<Progetto> progettiPosseduti, List<Progetto> progettiAutorizzati) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.creazione = LocalDateTime.now();
		this.progettiPosseduti = progettiPosseduti;
		this.progettiAutorizzati = progettiAutorizzati;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDateTime getCreazione() {
		return creazione;
	}

	public void setCreazione(LocalDateTime creazione) {
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

	public LocalDateTime getModifica() {
		return modifica;
	}

	public void setModifica(LocalDateTime modifica) {
		this.modifica = modifica;
	}
	

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

	public List<Commento> getCommenti() {
		return commenti;
	}

	public void setCommenti(List<Commento> commenti) {
		this.commenti = commenti;
	}
	

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((creazione == null) ? 0 : creazione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((progettiAutorizzati == null) ? 0 : progettiAutorizzati.hashCode());
		result = prime * result + ((progettiPosseduti == null) ? 0 : progettiPosseduti.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Utente u=(Utente)obj;
		return this.credentials.equals(u.getCredentials());
	}





}
