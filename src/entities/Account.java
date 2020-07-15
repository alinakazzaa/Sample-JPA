package entities;

import java.util.List;

import javax.persistence.*;


@NamedQueries( {
	@NamedQuery(name = "Account.findAll", query = "select o from Account o"),
	@NamedQuery(name = "Account.getById", query = "select o from Account o where o.id=:id"),
	@NamedQuery(name = "Account.getByUsername", query = "select o from Account o where o.username=:username"),
})

@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String username;
	private String full_name;
	private String password;
	private String email;
	private String location;
	private String insta_link;
	private String date_created;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	public Account() {

	}
	

	public Account(String username, String full_name, String password, String email, String location, String insta_link, String date_created) {
		this.username = username;
		this.password = password;
		this.full_name = full_name;
		this.email = email;
		this.location = location;
		this.insta_link = insta_link;
		this.date_created = date_created;
	}

	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getDate_created() {
		return date_created;
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

}
