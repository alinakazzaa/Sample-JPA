package entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@NamedQuery(name = "Collaboration.findAll", query = "select o from Collaboration o"),
	@NamedQuery(name = "Collaboration.findById", query = "select o from Collaboration o where o.id=:id"),
})

@Entity
public class Collaboration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String title;
	private String date_created;
	private String date_activated;
	private int reach;
	private String description;
	private boolean isActivated;
	
	@ManyToOne
	private Client client;
	
	@ManyToOne
	private InfluAccount influencer;
	
	@OneToMany(mappedBy = "collab", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Publication> publications;
	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public InfluAccount getInfluencer() {
		return influencer;
	}

	public void setInfluencer(InfluAccount influencer) {
		this.influencer = influencer;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	
	public void addPub(Publication pub) {
		this.publications.add(pub);
	}

	public String getDate_created() {
		return date_created;
	}

	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public String getDate_activated() {
		return date_activated;
	}

	public void setDate_activated(String date_activated) {
		this.date_activated = date_activated;
	}

	public int getReach() {
		return reach;
	}

	public void setReach(int reach) {
		this.reach = reach;
	}
	
	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collaboration() {
		
		
	}

	public Collaboration(String title, String date_created) {
		this.title = title;
		this.date_created = date_created;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

}
