package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries( {
	@NamedQuery(name = "Publication.findAll", query = "select o from Publication o"),
	@NamedQuery(name = "Publication.findById", query = "select o from Publication o where o.id=:id"),
})

@Entity
public class Publication {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String link;
	private String type;
	
	@ManyToOne
	private Collaboration collab;

	public Collaboration getCollab() {
		return collab;
	}

	public void setCollab(Collaboration collab) {
		this.collab = collab;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Publication(String link, String type) {

		this.link = link;
		this.type = type;
	}
	
	public Publication() {

	}

	public int getId() {
		return id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
