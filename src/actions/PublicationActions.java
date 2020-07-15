package actions;

import java.util.ArrayList;
import java.util.List;

import dao.CollaborationDAO;
import dao.PublicationDAO;
import entities.Collaboration;
import entities.Publication;

public class PublicationActions {

	CollaborationDAO collabdao = new CollaborationDAO();
	PublicationDAO pubdao = new PublicationDAO();
	Collaboration c;
	Publication p;

	public PublicationActions() {
		
//		addPubs();

		// display all publications
//		for (Publication p : pubdao.getAllPublications()) {
//			System.out.println("Got all publications links: " + p.getLink());
//		}
		
	//	get pub by id 
//		Publication p = getPublicationById(55);
//		System.out.println("Got publication by id: " + p.getLink());
		
		String link = "https://www.instagram.com/p/BzBGobRiOUu/";
		editPublicationLink(55, link);
	
//		p = pubdao.getPublicationById();
//		pubdao.removePub(p);
//		System.out.println(p.getLink() + " removed");

	}

	public void addPub(Publication pub, Collaboration collab) {
		// set collab of publication
		pub.setCollab(collab);
		// add publication to DB
		pubdao.persistPub(pub);
		// add to publication to collab
		collab.addPub(pub);
		collabdao.mergeCollab(collab);

		System.out.println("Added publication of id " + pub.getId() + " to " + collab.getTitle());
	}

	public List<Publication> getAllPublications() {
		List<Publication> publications = new ArrayList<Publication>();
		publications = pubdao.getAllPublications();

		return publications;
	}

	public Publication getPublicationById(int id) {
		Publication pub = pubdao.getPublicationById(id);
		return pub;
	}
	
	public void editPublicationLink(int id, String link) {
		Publication pub = pubdao.getPublicationById(id);
		pub.setLink(link);
		pubdao.mergePub(pub);
		System.out.println("Edited link of publication " + pub.getId() + " to " + link);	
	}
	
	public void addPubs() {
		 Publication pub = new Publication("https://www.instagram.com/p/B3faSWOBvge/",
		 "video");
		 c = collabdao.getCollabById(53);
		 addPub(pub, c);
	}

}
