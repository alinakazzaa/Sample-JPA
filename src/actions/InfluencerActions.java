package actions;

import java.util.ArrayList;
import java.util.List;

import entities.Media;
import entities.Project;
import dao.CollaborationDAO;
import dao.FetchJobDAO;
import dao.InfluencerDAO;
import dao.MediaDAO;
import dao.ProjectDAO;
import entities.FetchJob;
import entities.Influencer;

public class InfluencerActions {

	InfluencerDAO infdao = new InfluencerDAO();
	Influencer i;
	FetchJobDAO fjdao = new FetchJobDAO();
	FetchJob fj;
	MediaDAO medao = new MediaDAO();
	Media m;
	CollaborationDAO collabdao = new CollaborationDAO();
	ProjectDAO pdao = new ProjectDAO();
	Project p;

	public InfluencerActions() {

		 addInfluencers();

		// display all influencers
//		for (Influencer i : infdao.getAllInfluencers()) {
//			System.out.println("Got all influencers: " + i.getUsername());
//		}

//		 i = getInfluencerById(24);
//		 System.out.println("Got influencer by id: " + i.getUsername());
		
		// edit influencer
//		i = getInfluencerById(24);
//		i.setEmail("edit_g@gmail.com");
//		infdao.mergeInfluencer(i);
//		System.out.println("Changed email of influencer: " + i.getUsername() + " to edit_g@gmail.com");
		
//		 delete influencer
//		 i = infdao.getInfluencerById(id); 
//		 infdao.removeInfluencer(i);
//		 System.out.println("Removed influencer " + i.getUsername());
	}

	public void addInfluencer(Influencer influ, int pId, int fjId) {
		p = pdao.getProjectById(pId);
		// add to DB
		influ.setProject(p);
		infdao.persistInfluencer(influ);
		
		// add to fj
		fj = fjdao.getFetchJobById(fjId);
		fj.addInfluencer(influ);
		fjdao.mergeFetchJob(fj);

		System.out.println("Added " + influ.getUsername() + " to " + fj.getTitle() + "(project " + p.getTitle() + ")");
	}

	public List<Influencer> getAllInfluencers() {
		List<Influencer> influencers = new ArrayList<Influencer>();
		influencers = infdao.getAllInfluencers();

		return influencers;
	}

	public Influencer getInfluencerById(int id) {
		Influencer influ = infdao.getInfluencerById(id);
		return influ;
	}

	public void addInfluencers() {
		List<Media> media1 = new ArrayList<Media>();
		List<Media> media2 = new ArrayList<Media>();
		List<Media> media3 = new ArrayList<Media>();
		List<Media> media4 = new ArrayList<Media>();
		List<Media> media5 = new ArrayList<Media>();
		List<Media> media6 = new ArrayList<Media>();
		Media item1 = new Media("https://www.instagram.com/p/B2edbqdC-NksxMd4Kqc-O4wUp6VTFJnPomEmPc0/", "picture");
		Media item2 = new Media("https://www.instagram.com/p/B2edbqdC-NksxMd4Kqc-O4wUp6VTFJnPomEmPc0/", "picture");
		Media item3 = new Media("https://www.instagram.com/p/B2edbqdC-NksxMd4Kqc-O4wUp6VTFJnPomEmPc0/", "picture");
		Media item4 = new Media("https://www.instagram.com/p/B2edbqdC-NksxMd4Kqc-O4wUp6VTFJnPomEmPc0/", "picture");
		Media item5 = new Media("https://www.instagram.com/p/B2edbqdC-NksxMd4Kqc-O4wUp6VTFJnPomEmPc0/", "picture");
		Media item6 = new Media("https://www.instagram.com/p/B2edbqdC-NksxMd4Kqc-O4wUp6VTFJnPomEmPc0/", "picture");
		
		medao.persistMedia(item1);
		medao.persistMedia(item2);
		medao.persistMedia(item3);
		medao.persistMedia(item4);
		medao.persistMedia(item5);
		medao.persistMedia(item6);
		
		media1.add(item1);
		media2.add(item2);
		media3.add(item3);
		media4.add(item4);
		media5.add(item5);
		media6.add(item6);
		
		
		i = new Influencer("anni0nik", "Anni Nik", "anni@gmail.com", "Arklow, Ireland",
				"https://www.instagram.com/anni0nik/", 455, 45345, 54);
		i.setMedia(media1);
		addInfluencer(i, 4, 11);
		
		i = new Influencer("_guillermomueller_", "Guillermo/William Mueller", "g@gmail.com", "Saint Prex, Switzerland",
				"https://www.instagram.com/_guillermomueller_/", 435, 4566, 45);
		i.setMedia(media2);
		addInfluencer(i, 4, 11);
		
		i = new Influencer("an_dray_a", "Andrea Baltag", "andy@gmail.com", "Mullingar, Ireland",
				"https://www.instagram.com/an_dray_a/", 654, 5645, 56);
		i.setMedia(media3);
		addInfluencer(i, 4, 11);
		
		i = new Influencer("nic.boi", "Nicu Boian", "nic@gmail.com", "Dublin,Ireland",
				"https://www.instagram.com/nic.boi/", 346, 74633, 56);
		i.setMedia(media4);
		addInfluencer(i, 4, 12);
		i = new Influencer("nakt_studio", "Nakt Studio", "nakt@gmail.com", "Berlin, Germany",
				"https://www.instagram.com/nakt_studio/", 8767, 56466, 200);
		i.setMedia(media5);
		addInfluencer(i, 4, 12);
		
		i = new Influencer("apasnayaryka", "Апасный", "apasny@gmail.com", "Moscow,Russia",
				"https://www.instagram.com/apasnayaryka/", 643, 75333, 96);
		i.setMedia(media6);
		addInfluencer(i, 4, 12);
	}
}
