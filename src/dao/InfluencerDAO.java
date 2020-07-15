package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Influencer;

public class InfluencerDAO {
	
	public InfluencerDAO() {
		
	}
	
	// create entity manager factory
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("influSysPU");
	
	// add Influencer to DB
	public void persistInfluencer(Influencer influ) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(influ);
		em.getTransaction().commit();
		em.close();
		
	}
	
	// edit Influencer
	public Influencer mergeInfluencer(Influencer influ) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Influencer updatedInfluencer = em.merge(influ);
		em.getTransaction().commit();
		em.close();
		
		return updatedInfluencer;
		
	}
	
	// delete Influencer
	public void removeInfluencer(Influencer influ) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(influ);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Influencer> getAllInfluencers() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Influencer> influencers = (List<Influencer>)
				em.createNamedQuery("Influencer.findAll").getResultList();
		em.close();
		
		return influencers;
	}
	
	public Influencer getInfluencerById(int id) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Influencer> influencers = (List<Influencer>) 
				em.createNamedQuery("Influencer.findById")
				.setParameter("id", id).getResultList();
		em.close();
		
		Influencer influ = null;
		for(Influencer i: influencers) {
			influ = i;
		}
		
		return influ;
	}
	
}
