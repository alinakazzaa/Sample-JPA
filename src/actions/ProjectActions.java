package actions;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import entities.Client;
import dao.AccountDAO;
import dao.ProjectDAO;
import entities.Project;

public class ProjectActions {

	protected ProjectDAO projectdao = new ProjectDAO();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss z");
	String date = formatter.format(new Date(System.currentTimeMillis()));
	ProjectDAO projdao = new ProjectDAO();
	Project p;
	AccountDAO accdao = new AccountDAO();
	Client c;

	public ProjectActions() {
//		 test data
//		addProjects();
		
		// get all projects
//		getAllProjects();
		
		// get project by id 
//		getProjectById(7);
		
		// edit project
//		 p = getProjectById(6);
//		 p.setTitle("Changed Project 2");
//		 projdao.mergeProject(p);
//		 System.out.println("Changed title to " + p.getTitle());
		
		// delete project
//		p = getProjectById(5);
//		projdao.removeProject(p);
//		System.out.println("Removed project " + p.getTitle());
		
	}

	public void addProject(Project project) {
		projectdao.persistProject(project);
	}

	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<Project>();
		projects = projectdao.getAllProjects();
		
		for(Project p : projects) {
			System.out.println("Got all projects: " + p.getTitle());
		}
		return projects;
	}

	public Project getProjectById(int id) {
		p = projectdao.getProjectById(id);
		System.out.println("Project by id: " + p.getTitle());
		return p;
	}
	
	public void addProjects() {
		// create
		c = accdao.getClientById(1);
		p = new Project("Project 1", date);
		p.setClient(c);
		addProject(p);
		// add to client
		c.getProjects().add(p);
		accdao.mergeClient(c);
		System.out.println("Added: " + p.getTitle() + " to " + c.getUsername());
		
		c = accdao.getClientById(2);
		p = new Project("Project 2", date);
		p.setClient(c);
		addProject(p);
		c.getProjects().add(p);
		accdao.mergeClient(c);
		System.out.println("Added: " + p.getTitle() + " to " + c.getUsername());
		
		c = accdao.getClientById(2);
		p = new Project("Project 3", date);
		p.setClient(c);
		addProject(p);
		c.getProjects().add(p);
		accdao.mergeClient(c);
		System.out.println("Added: " + p.getTitle() + " to " + c.getUsername());
		
		c = accdao.getClientById(3);
		p = new Project("Project 4", date);
		p.setClient(c);
		addProject(p);
		c.getProjects().add(p);
		accdao.mergeClient(c);
		System.out.println("Added: " + p.getTitle() + " to " + c.getUsername());
		
		c = accdao.getClientById(3);
		p = new Project("Project 5", date);
		p.setClient(c);
		addProject(p);
		c.getProjects().add(p);
		accdao.mergeClient(c);
		System.out.println("Added: " + p.getTitle() + " to " + c.getUsername());
		
	}

}
