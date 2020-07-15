package entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@NamedQueries({ @NamedQuery(name = "FetchJob.findAll", query = "select o from FetchJob o"),
		@NamedQuery(name = "FetchJob.findById", query = "select o from FetchJob o where o.id=:id")
})

@Entity
public class FetchJob {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String date;
	private String type;
	private String keyword;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Influencer> influencers;

	public List<Influencer> getInfluencers() {
		return influencers;
	}

	public void setInfluencers(List<Influencer> influencers) {
		this.influencers = influencers;
	}
	
	public void addInfluencer(Influencer influ) {
		this.influencers.add(influ);
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public FetchJob() {

	}

	public FetchJob(String title, String date, String type, String keyword) {
		this.title = title;
		this.date = date;
		this.type = type;
		this.keyword = keyword;
	}
	
	public String getDate() {
		return date;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
