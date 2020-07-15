package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

//import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQueries( {
	@NamedQuery(name = "Project.findAll", query = "select o from Project o"),
	@NamedQuery(name = "Project.findById", query = "select o from Project o where o.id=:id"),
})

@Entity
@Embeddable
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String title;
	private String date;
	
	@ManyToOne
	private Client client;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FetchJob> fetch_jobs;

	public List<FetchJob> getFetch_jobs() {
		return fetch_jobs;
	}

	public void setFetch_jobs(List<FetchJob> fetch_jobs) {
		this.fetch_jobs = fetch_jobs;
	}
	
	public void addFetchJob(FetchJob f_job) {
		this.fetch_jobs.add(f_job);
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public Project() {

	}
	
	public Project(String title, String date) {
		this.title = title;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public int getProject_id() {
		return id;
	}

	public void setProject_id(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
