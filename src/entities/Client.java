package entities;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


@NamedQueries( {
	@NamedQuery(name = "Client.findAll", query = "select o from Client o"),
	@NamedQuery(name = "Client.getById", query = "select o from Client o where o.id=:id"),
	@NamedQuery(name = "Client.getByUsername", query = "select o from Client o where o.username=:username"),
})

@Entity
public class Client extends Account {
	public Client(String username, String full_name, String password, String email, String location, String insta_link,
			String date_created, String companyName) {
		super(username, full_name, password, email, location, insta_link, date_created);
		this.companyName = companyName;
	}

	private String companyName;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Project> projects;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Collaboration> collabs;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Conversation> convos;

	public List<Conversation> getConvos() {
		return convos;
	}

	public void setConvos(List<Conversation> convos) {
		this.convos = convos;
	}
	
	public void addConvo(Conversation convo) {
		this.convos.add(convo);
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public Client() {
		super();
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project p) {
		this.projects.add(p);
	}
	
	
	public List<Collaboration> getCollabs() {
		return collabs;
	}

	public void setCollabs(List<Collaboration> collabs) {
		this.collabs = collabs;
	}
	
	public void addCollab(Collaboration collab) {
		this.collabs.add(collab);
	}

}
