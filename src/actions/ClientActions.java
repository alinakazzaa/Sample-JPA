package actions;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Account;
import entities.Client;
import entities.Conversation;
import entities.InfluAccount;
import entities.Message;
import dao.AccountDAO;
import dao.ConversationDAO;
import dao.MessageDAO;
import dao.ProjectDAO;
import entities.Project;

public class ClientActions {

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss z");
	String date = formatter.format(new Date(System.currentTimeMillis()));
	protected AccountDAO accdao = new AccountDAO();
	protected ConversationDAO condao = new ConversationDAO();
	protected MessageDAO mesdao = new MessageDAO();
	private Client cli;
	private List<Client> clients;
	private List<Project> projects;
	private Conversation convo;
	private InfluAccount inf;
	

	public ClientActions() {
		// test data
//		addClients();
		
		// get all clients
//		clients = getAllClients();
//		for (Client c : clients) {
//			System.out.println("Clients: " + c.getUsername());
//
//		}
		
		// get client by id & username
//		cli = getClientByUsername("alinakazzaa");
//		System.out.println("Got client " + cli.getUsername() + " by username");
		
		// by id
//		cli = getClientById(1);
//		System.out.println("Got client " + cli.getUsername() + " by id");
		
		// get projects of account
//		cli = getClientByUsername("alinakazzaa");
//		projects = cli.getProjects();
//		for (Project p : projects) {
//			System.out.println("Projects of " + cli.getUsername() + ": " + p.getTitle());
//
//		}
		
		// edit account
//		 ac.setPassword("new password");
//		 accountdao.mergeAccount(ac);
//		 System.out.println(ac.getUsername() + " password changed to " + "new password");
		
		// delete account
//		 accountdao.removeAccount(ac);
//		 System.out.println("Removed client account " + ac.getUsername());
		
		
		cli = accdao.getClientByUsername("alinakazzaa");
		inf = accdao.getInfluAccByUsername("an_dra_ya");
//		startConversation(cli, inf);
		String msg = "Hey there! You wanna collaborate?";
//		clientSendMessage(cli, inf, msg);
//		influSendMessage(inf, cli, msg);
		
		
	}

	public void addClient(Client c) {
		accdao.persistClient(c);
	}

	public Client getClientByUsername(String username) {
		cli = accdao.getClientByUsername(username);
		return cli;
	}

	public Client getClientById(int id) {
		cli = accdao.getClientById(id);
		return cli;
	}

	public List<Client> getAllClients() {
		clients = new ArrayList<Client>();
		clients = accdao.getAllClients();
		return clients;
	}
	
	public List<Project> getClientProjects(Client c) {
		
		System.out.println("Getting projects of client account...");
		return projects;
	}
	
	public void addClients() {
		cli = new Client("alinakazzaa", "Alina Kazakova", "mypass", "alina@inbox.ie",
				"Dublin, Ireland", "https://www.instagram.com/alinakazzaa/", date, "IDG");
		addClient(cli);
		cli = new Client("aaron_leaahy", "AAron Leahy", "myAcc", "aaron@inbox.ie", "Tokyo, Japan",
				"https://www.instagram.com/aaron_leahy/", date, "Coffee Co.");
		addClient(cli);
		cli = new Client("john-smith", "John Smith", "anAccount", "js@inbox.ie", "London, Great Britain",
				"https://www.instagram.com/john-smith/", date, "Local Butcher Co.");
		addClient(cli);
		
	}
	
	public void startConversation(Client c, InfluAccount i) {
		convo = new Conversation();
		convo.setClient(c);
		convo.setInflu(i);
		condao.persistConversation(convo);
		c.addConvo(convo);
		accdao.mergeClient(c);
		convo = condao.getConvoById(87);
		i.addConvo(convo);
		accdao.mergeInfluAcc(i);
	}
	
	public void influSendMessage(InfluAccount i, Client c, String msg) {
		Message m = new Message(i, msg, date);
		List<Conversation> convos = i.getConvos();
		
		for(Conversation con: convos) {
			if(c.getUsername().equals(con.getClient().getUsername())) {
				m.setConvo(con);
				mesdao.persistMessage(m);
				con.addMessage(m);
				condao.mergeConvo(con);
				System.out.println(i.getUsername() + " influencer sent a message to client" + c.getUsername());
			}
		}	
	}
	
	public void clientSendMessage(Client c, InfluAccount i, String msg) {
		Message m = new Message(c, msg, date);
		List<Conversation> convos = c.getConvos();
		
		for(Conversation con: convos) {
			if(i.getUsername().equals(con.getInflu().getUsername())) {
				m.setConvo(con);
				mesdao.persistMessage(m);
				con.addMessage(m);
				condao.mergeConvo(con);
				System.out.println(c.getUsername() + " client sent a message to influencer " + i.getUsername());
			}
		}	
	}
}
