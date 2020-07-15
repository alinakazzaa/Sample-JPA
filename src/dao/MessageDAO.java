package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Message;

public class MessageDAO {
	// create entity manager factory
			protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("influSysPU");


	// add message to DB
	public void persistMessage(Message msg) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(msg);
		em.getTransaction().commit();
		em.close();

	}

	// edit message
	public Message mergeMessage(Message msg) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Message updatedMessage = em.merge(msg);
		em.getTransaction().commit();
		em.close();

		return updatedMessage;

	}

	// delete message
	public void removeMessage(Message msg) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(msg));
		em.getTransaction().commit();
		em.close();
	}

}
