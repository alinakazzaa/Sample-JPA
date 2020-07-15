package actions;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.InfluAccount;
import entities.Media;
import dao.AccountDAO;
import dao.MediaDAO;


public class InfluAccountActions {

	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss z");
	String date = formatter.format(new Date(System.currentTimeMillis()));
	protected AccountDAO accdao = new AccountDAO();
	private InfluAccount inf;
//	private List<InfluAccount> influs;
	MediaDAO medao = new MediaDAO();
	Media m;

	public InfluAccountActions() {
		// test data
//		addInfluAccounts();
		
		// get all influ accounts
//		influs = accdao.getAllInfluAccounts();
//		for (InfluAccount ia : influs) {
//			System.out.println("Influencer accounts: " + ia.getUsername());
//		}
		
		// get client by id & username
//		inf = accdao.getInfluAccByUsername("an_dra_ya");
//		System.out.println("Got influencer account " + inf.getUsername() + " by username");
		
		// by id
//		inf = accdao.getInfluAccountById(47);
//		System.out.println("Got influencer account " + inf.getUsername() + " by id");
		

		
		// edit influencer account
//		 inf = accdao.getInfluAccountById(47);
//		 inf.setPassword("new password");
//		 accdao.mergeInfluAcc(inf);
//		 System.out.println(inf.getUsername() + " password changed to " + "new password");
		
		// delete account account
//		 inf = accdao.getInfluAccountById(47);
//		 accdao.removeInfluAcc(inf);
//		 System.out.println("Removed influencer account " + inf.getUsername());
		
//		System.out.println("Got influencer " + getInfluAccountByUsername("an_dra_ya").getUsername() + " by username");
//		accdao.removeInfluAcc(getInfluAccountByUsername("an_dra_ya"));
		
	}

	public void addInfAccount(InfluAccount ia) {
		accdao.persistInfluAcc(ia);
	}
//
	public InfluAccount getInfluAccountByUsername(String username) {
		inf = accdao.getInfluAccByUsername(username);
		return inf;
	}
//
	public InfluAccount getInfluAccById(int id) {
		inf = accdao.getInfluAccountById(id);
		return inf;
	}
	
	public void addInfluAccounts() {
		List<Media> media = new ArrayList<Media>();
		Media item = new Media("https://www.instagram.com/p/B2edbqdC-NksxMd4Kqc-O4wUp6VTFJnPomEmPc0/", "picture");
		medao.persistMedia(item);
		media.add(item);
		
		inf = new InfluAccount("an_dra_ya", "Andrea Baltag", "andy123", "andrea@inbox.ie", "Mullingar, Ireland",
				"https://www.instagram.com/an_dra_ya/", date);
		inf.setMedia(media);
		accdao.mergeInfluAcc(inf);
		addInfAccount(inf);
	}
}