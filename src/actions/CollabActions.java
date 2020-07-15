package actions;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Client;

import dao.AccountDAO;
import dao.CollaborationDAO;
import entities.Collaboration;
import entities.InfluAccount;

public class CollabActions {
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss z");
	String date = formatter.format(new Date(System.currentTimeMillis()));
	CollaborationDAO collabdao = new CollaborationDAO();
	AccountDAO accdao = new AccountDAO();
	InfluAccount i;
	Collaboration c;
	Client cli;

	public CollabActions() {
		// test data
		 addCollabs();

		// display all collaborations
//		for (Collaboration c : collabdao.getAllCollabs()) {
//			System.out.println("Got all collaborations: " + c.getTitle());
//		}

		// get collabs by id
//		 c = getCollabById(55);
//		 System.out.println("Got collab by id: " + c.getTitle());
		
		// edit collab (influencer) 
		c = getCollabById(55);
		//c.setInfluencer(infdao.getInfluencerById(49));
		c.setTitle("New Title");
		collabdao.mergeCollab(c);
		System.out.println("Changed title of collab: " + c.getTitle() + " to " + "New Title");
		
//		 delete collab
//		deleteCollab(55);
		
	}

	public void addCollab(Collaboration collab, Client client, InfluAccount influ) {
		client.addCollab(collab);
		influ.addCollab(collab);
		collab.setClient(client);
		collab.setInfluencer(influ);
		collabdao.persistCollab(collab);
		System.out.println("Added " + collab.getTitle() + " to client " + client.getUsername() + " collaborating with " + influ.getUsername());
	}
	
	public List<Collaboration> getAllCollabs() {
		List<Collaboration> collabs = new ArrayList<Collaboration>();
		collabs = collabdao.getAllCollabs();

		return collabs;
	}

	public Collaboration getCollabById(int id) {
		Collaboration collab = collabdao.getCollabById(id);
		return collab;
	}
	
	public void deleteCollab(int id) {
		Collaboration collab = collabdao.getCollabById(id);
		collabdao.removeCollab(collab);
		System.out.println(collab.getTitle() + " removed");
	}
	
	public void addCollabs() {
		// create
		c = new Collaboration("Collaboration 1", date);
		// get client & influ that will be collaborating
		cli = accdao.getClientById(1);
		i = accdao.getInfluAccountById(47);
		addCollab(c, cli, i);
		
		c = new Collaboration("Collaboration 2", date);
		cli = accdao.getClientById(1);
		i = accdao.getInfluAccountById(47);
		addCollab(c, cli, i);
	}

}
