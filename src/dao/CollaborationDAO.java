package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Collaboration;

public class CollaborationDAO {
	
public CollaborationDAO() {
		
	}
	
	// create entity manager factory
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("influSysPU");
	
	// add Collab to DB
	public void persistCollab(Collaboration collab) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(collab);
		em.getTransaction().commit();
		em.close();
		
	}
	
	// edit Collab
	public Collaboration mergeCollab(Collaboration collab) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Collaboration updatedCollab = em.merge(collab);
		em.getTransaction().commit();
		em.close();
		
		return updatedCollab;
		
	}
	
	// delete Collab
	public void removeCollab(Collaboration collab) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Object managed = em.merge(collab);
		em.remove(managed);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Collaboration> getAllCollabs() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Collaboration> collabs = (List<Collaboration>)
				em.createNamedQuery("Collaboration.findAll").getResultList();
		em.close();
		
		return collabs;
	}
	
	public Collaboration getCollabById(int id) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Collaboration> collabs = (List<Collaboration>) 
				em.createNamedQuery("Collaboration.findById")
				.setParameter("id", id).getResultList();
		em.close();
		
		Collaboration collab = null;
		for(Collaboration c: collabs) {
			collab = c;
		}
		
		return collab;
	}
	
	public List<Collaboration> getCollabsByInfluId(int influId) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Collaboration> collabs = (List<Collaboration>) 
				em.createNamedQuery("Collaboration.findById")
				.setParameter("id", influId).getResultList();
		em.close();
		
		return collabs;
	}

}
