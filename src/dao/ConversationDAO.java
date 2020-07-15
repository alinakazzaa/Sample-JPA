package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Account;
import entities.Conversation;

public class ConversationDAO {
	
	// create entity manager factory
		protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("influSysPU");

		// add convo to DB
		public void persistConversation(Conversation convo) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(convo);
			em.getTransaction().commit();
			em.close();

		}

		// edit convo
		public Conversation mergeConvo(Conversation convo) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Conversation updatedConvo = em.merge(convo);
			em.getTransaction().commit();
			em.close();

			return updatedConvo;

		}

		// delete convo
		public void removeConvo(Conversation convo) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(em.merge(convo));
			em.getTransaction().commit();
			em.close();
		}
		
		public List<Conversation> getAllConvos() {
			EntityManager em = emf.createEntityManager();
			@SuppressWarnings("unchecked")
			List<Conversation> convos = (List<Conversation>) em.createNamedQuery("Conversation.getAll")
					.getResultList();
			em.close();
			return convos;
		}
		
		public Conversation getConvoById(int id) {
			EntityManager em = emf.createEntityManager();
			@SuppressWarnings("unchecked")
			List<Conversation> convos = (List<Conversation>) em.createNamedQuery("Conversation.getById").setParameter("id", id)
					.getResultList();
			em.close();

			// GET the first account with that id
			Conversation con = null;
			for (Conversation c : convos) {
				con = c;
			}
			return con;
		}

}
