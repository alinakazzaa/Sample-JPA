package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String text;
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@ManyToOne 
	private Account sender;
	
	@ManyToOne 
	private Conversation convo;
	
	public Conversation getConvo() {
		return convo;
	}
	public void setConvo(Conversation convo) {
		this.convo = convo;
	}
	public Account getSender() {
		return sender;
	}
	public void setSender(Account sender) {
		this.sender = sender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Message(Account sender, String text, String date) {
		super();
		this.sender = sender;
		this.text = text;
		this.date = date;
	}
	public Message() {
		super();
	}
	
	
}
