package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Project;

public class ProjectDAO {
	
	protected EntityManager em = emf.createEntityManager();
	
	// create entity manager factory
		protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("influSysPU");
		
		// add account to DB
		public void persistProject(Project project) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(project);
			em.getTransaction().commit();
			em.close();
			
		}
		
		// edit account
		public Project mergeProject(Project project) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Project updatedProject = em.merge(project);
			em.getTransaction().commit();
			em.close();
			
			return updatedProject;
			
		}
		
		// delete account
		public void removeProject(Project project) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(project));
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Project> getAllProjects() {
			EntityManager em = emf.createEntityManager();
			@SuppressWarnings("unchecked")
			List<Project> projects = (List<Project>)
					em.createNamedQuery("Project.findAll").getResultList();
			em.close();
			
			return projects;
		}
		
		public Project getProjectById(int id) {
			EntityManager em = emf.createEntityManager();
			@SuppressWarnings("unchecked")
			List<Project> projects = (List<Project>) 
					em.createNamedQuery("Project.findById")
					.setParameter("id", id).getResultList();
			em.close();
			
			Project proj = null;
			for(Project p : projects) {
				proj = p;
			}
			
			return proj;
		}
}
