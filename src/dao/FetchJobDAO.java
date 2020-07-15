package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import entities.FetchJob;

@NamedQueries( {
	@NamedQuery(name = "FetchJob.findAll", query = "select o from FetchJob o"),
	@NamedQuery(name = "FetchJob.findById", query = "select o from FetchJob o where o.id=:id"),
})

public class FetchJobDAO {
	
	public FetchJobDAO() {
		
	}
	
	// create entity manager factory
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("influSysPU");
	
	// add FetchJob to DB
	public void persistFetchJob(FetchJob fj) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(fj);
		em.getTransaction().commit();
		em.close();
		
	}
	
	// edit FetchJob
	public FetchJob mergeFetchJob(FetchJob fj) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		FetchJob updatedFetchJob = em.merge(fj);
		em.getTransaction().commit();
		em.close();
		
		return updatedFetchJob;
		
	}
	
	// delete FetchJob
	public void removeFetchJob(FetchJob fj) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(fj));
		em.getTransaction().commit();
		em.close();
	}
	
	public List<FetchJob> getAllFetchJobs() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<FetchJob> fJobs = (List<FetchJob>)
				em.createNamedQuery("FetchJob.findAll").getResultList();
		em.close();
		
		return fJobs;
	}
	
	public FetchJob getFetchJobById(int id) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<FetchJob> fJobs = (List<FetchJob>) 
				em.createNamedQuery("FetchJob.findById")
				.setParameter("id", id).getResultList();
		em.close();
		
		FetchJob fJob = null;
		for(FetchJob fj: fJobs) {
			fJob = fj;
		}
		
		return fJob;
	}
}
