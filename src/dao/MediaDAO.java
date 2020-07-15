package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Media;


public class MediaDAO {
	
	public MediaDAO() {
		
	}
	
	// create entity manager factory
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("influSysPU");
	
	// add Media to DB
	public void persistMedia(Media m) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		
	}
	
	// edit Media
	public Media mergeMedia(Media m) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Media updatedM = em.merge(m);
		em.getTransaction().commit();
		em.close();
		
		return updatedM;
		
	}
	
	// delete Media
	public void removeMedia(Media m) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(m);
		em.getTransaction().commit();
		em.close();
	}
}