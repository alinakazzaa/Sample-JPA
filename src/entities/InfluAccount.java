package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries( {
	@NamedQuery(name = "InfluAccount.findAll", query = "select o from InfluAccount o"),
	@NamedQuery(name = "InfluAccount.getById", query = "select o from InfluAccount o where o.id=:id"),
	@NamedQuery(name = "InfluAccount.getByUsername", query = "select o from InfluAccount o where o.username=:username"),
})

@Entity
public class InfluAccount extends Account {
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Media> media = new ArrayList<Media>();
	
	@OneToMany(mappedBy = "influencer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Collaboration> collabs = new ArrayList<Collaboration>();
	
	@OneToMany(mappedBy = "influ", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
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

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public InfluAccount() {
		super();
	}

	public InfluAccount(String username, String full_name, String password, String email, String location,
			String insta_link, String date_created) {
		super(username, full_name, password, email, location, insta_link, date_created);
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
