package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Publication;

public class PublicationDAO {

public PublicationDAO() {
		
	}
	
	// create entity manager factory
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("influSysPU");
	
	// add Publication to DB
	public void persistPub(Publication pub) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pub);
		em.getTransaction().commit();
		em.close();
		
	}
	
	// edit Publication
	public Publication mergePub(Publication pub) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Publication updatedPub = em.merge(pub);
		em.getTransaction().commit();
		em.close();
		
		return updatedPub;
		
	}
	
	// delete Publication
	public void removePub(Publication pub) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object managed = em.merge(pub);
		em.remove(managed);
		em.getTransaction().commit();
		em.close();
	}
	
	// get all publications
	public List<Publication> getAllPublications() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Publication> publications = (List<Publication>)
				em.createNamedQuery("Publication.findAll").getResultList();
		em.close();
		
		return publications;
	}
	
	// get publication by Id
	public Publication getPublicationById(int id) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Publication> publications = (List<Publication>) 
				em.createNamedQuery("Publication.findById")
				.setParameter("id", id).getResultList();
		em.close();
		
		Publication pub = null;
		for(Publication p: publications) {
			pub = p;
		}
		
		return pub;
	}

}
