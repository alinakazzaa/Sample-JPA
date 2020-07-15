package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import entities.Influencer;

@NamedQueries( {
	@NamedQuery(name = "Influencer.findAll", query = "select o from Influencer o"),
	@NamedQuery(name = "Influencer.findById", query = "select o from Influencer o where o.id=:id"),
})

@Entity
@Embeddable
public class Influencer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String full_name;
	private String email;
	private String location;
	private String insta_link;
	private int following;
	private int followers;
	private int no_of_posts;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Media> media = new ArrayList<Media>();
	
	@ManyToOne
	private Project project;

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	public List<Media> getMedia() {
		return media;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Influencer(String username, String full_name, String email, String location, String insta_link,
			int following, int followers, int no_of_posts) {
		this.username = username;
		this.full_name = full_name;
		this.email = email;
		this.location = location;
		this.insta_link = insta_link;
		this.following = following;
		this.followers = followers;
		this.no_of_posts = no_of_posts;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInsta_link() {
		return insta_link;
	}

	public void setInsta_link(String insta_link) {
		this.insta_link = insta_link;
	}

	public int getFollowing() {
		return following;
	}

	public void setFollowing(int following) {
		this.following = following;
	}

	public int getFollowers() {
		return followers;
	}

	public void setFollowers(int followers) {
		this.followers = followers;
	}

	public int getNo_of_posts() {
		return no_of_posts;
	}

	public void setNo_of_posts(int no_of_posts) {
		this.no_of_posts = no_of_posts;
	}

	public Influencer() {

	}

}
