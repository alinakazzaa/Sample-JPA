package actions;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import dao.FetchJobDAO;
import dao.ProjectDAO;
import entities.FetchJob;
//import entities.Influencer;
import entities.Project;

public class FetchJobActions {
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss z");
	ProjectDAO projdao = new ProjectDAO();
	FetchJobDAO fjdao = new FetchJobDAO();
	FetchJob fj;
	Project p;
	
	public FetchJobActions(SimpleDateFormat formatter, String date) {

		
	}

	String date = formatter.format(new Date(System.currentTimeMillis()));

	public FetchJobActions() {
		
//		 test data
		addFetchJobs();
		
		// get all fetch job
//		getAllFetchJobs();
		
		// get fetch job by id 
//		getFetchJobById(19);
		
		// edit fetch job
//		 fj = getFetchJobById(19);
//		 fj.setTitle("Changed Project 2 IDG Fetch Hashtag 14-10-2019 20-03-19 IST");
//		 fjdao.mergeFetchJob(fj);
//		 System.out.println("Changed title to " + fj.getTitle());
		
		// delete fetch job
//		fj = getFetchJobById(21);
//		fjdao.removeFetchJob(fj);
//		System.out.println("Removed fetch job " + fj.getTitle());
		
		// add to project
//		ProjectDAO pdao = new ProjectDAO();
//		Project project = pdao.getProjectById(3);
//		
//		project.addFetchJob(fj);
//		pdao.mergeProject(project);
//		System.out.println("Added fetch job " + fj.getTitle() + " to " + project.getTitle());
		
//		FetchJobDAO fjdao = new FetchJobDAO();
//		FetchJob fj = fjdao.getFetchJobById(8);
//		System.out.println("Fetch Job By ID: " + fj.getTitle());
		
	}

	public void addFetchJob(FetchJob fj, int projId) { // projId will come from the state i.e. current project
		fjdao.persistFetchJob(fj);
		// add to project
		p = projdao.getProjectById(projId);
		p.addFetchJob(fj);
		projdao.mergeProject(p);
		System.out.println("Added fetch job " + fj.getTitle() + " to project " + p.getTitle());
	}
	
	public void addFetchJobs() {
		FetchJob fj1 = new FetchJob("Project 2 IDG Fetch Hashtag " + date, date, "hashtag", "marketing");	
		addFetchJob(fj1, 7);
		FetchJob fj2 = new FetchJob("Project 2 Coffee Bean Fetch Location " + date, date, "location", "London");
		addFetchJob(fj2, 7);
	}
	
	public List<FetchJob> getAllFetchJobs() {
	List<FetchJob> fjs = new ArrayList<FetchJob>();
	fjs = fjdao.getAllFetchJobs();
	
	for (FetchJob fj: fjs) {
		System.out.println("All fetch jobs: " + fj.getTitle());
	}
	
	return fjs;
 }
	
	public FetchJob getFetchJobById(int id) {
	fj = fjdao.getFetchJobById(id);
	System.out.println("Got fetch job by id " + id + ": " + fj.getTitle());
	return fj;
}
}
