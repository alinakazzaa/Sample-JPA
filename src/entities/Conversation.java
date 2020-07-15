package entities;

import java.util.List;

import javax.persistence.CascadeType;
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
	@NamedQuery(name = "Conversation.findAll", query = "select o from Conversation o"),
	@NamedQuery(name = "Conversation.getById", query = "select o from Conversation o where o.id=:id"),
})

@Entity
public class Conversation {
	
	public Conversation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy="convo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Message> messages;
	
	@ManyToOne
	private InfluAccount influ;
	
	@ManyToOne
	private Client client;

	public InfluAccount getInflu() {
		return influ;
	}
	public void setInflu(InfluAccount influ) {
		this.influ = influ;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	public void addMessage(Message msg) {
		this.messages.add(msg);
	}
}
