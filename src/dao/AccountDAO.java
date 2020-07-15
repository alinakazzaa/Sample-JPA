package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Account;
import entities.Client;
import entities.InfluAccount;

public class AccountDAO {

	public AccountDAO() {

	}

	// create entity manager factory
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("influSysPU");

	// add account to DB
	public void persistClient(Client client) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(client);
		em.getTransaction().commit();
		em.close();

	}

	// edit account
	public Client mergeClient(Client client) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Client updatedClient = em.merge(client);
		em.getTransaction().commit();
		em.close();

		return updatedClient;

	}

	// delete account
	public void removeClient(Client client) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(client));
		em.getTransaction().commit();
		em.close();
	}

	public Client getClientByUsername(String username) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Client> clients = (List<Client>) em.createNamedQuery("Client.getByUsername").setParameter("username", username)
				.getResultList();
		em.close();

		// GET the first account with that id
		Client cli = null;
		for (Client c : clients) {
			cli = c;
		}

		return cli;
	}
	
	public InfluAccount getInfluAccByUsername(String username) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<InfluAccount> influs = (List<InfluAccount>) em.createNamedQuery("InfluAccount.getByUsername").setParameter("username", username)
				.getResultList();
		em.close();

		// GET the first account with that id
		InfluAccount infA = null;
		for (InfluAccount ia : influs) {
			infA = ia;
		}

		return infA;
	}
	
	public Client getClientById(int id) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Client> clients = (List<Client>) em.createNamedQuery("Client.getById").setParameter("id", id)
				.getResultList();
		em.close();

		// GET the first account with that id
		Client cli = null;
		for (Client c : clients) {
			cli = c;
		}

		return cli;
	}
	

	public InfluAccount getInfluAccountById(int id) {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<InfluAccount> influs = (List<InfluAccount>) em.createNamedQuery("InfluAccount.getById").setParameter("id", id)
				.getResultList();
		em.close();

		// GET the first account with that id
		InfluAccount infA = null;
		for (InfluAccount ia : influs) {
			infA = ia;
		}

		return infA;
	}

	public List<Client> getAllClients() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<Client> clients = (List<Client>) em.createNamedQuery("Client.findAll").getResultList();
		em.close();

		return clients;
	}
	
	public List<InfluAccount> getAllInfluAccounts() {
		EntityManager em = emf.createEntityManager();
		@SuppressWarnings("unchecked")
		List<InfluAccount> influs = (List<InfluAccount>) em.createNamedQuery("InfluAccount.findAll").getResultList();
		em.close();

		return influs;
	}

	// add influ account to DB
	public void persistInfluAcc(InfluAccount ia) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(ia);
		em.getTransaction().commit();
		em.close();

	}

	// edit influ account
	public InfluAccount mergeInfluAcc(InfluAccount ia) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		InfluAccount updatedInflu = em.merge(ia);
		em.getTransaction().commit();
		em.close();

		return updatedInflu;

	}

	// delete influ accout
	public void removeInfluAcc(InfluAccount ia) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(ia));
		em.getTransaction().commit();
		em.close();
	}

		// edit account
		public Account mergeAccount(Account acc) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Account updatedAccount = em.merge(acc);
			em.getTransaction().commit();
			em.close();

			return updatedAccount;

		}
		
		public Account getAccountById(int id) {
			EntityManager em = emf.createEntityManager();
			@SuppressWarnings("unchecked")
			List<Account> accs = (List<Account>) em.createNamedQuery("Account.getById").setParameter("id", id)
					.getResultList();
			em.close();

			// GET the first account with that id
			Account acc = null;
			for (Account a : accs) {
				acc = a;
			}

			return acc;
		}
		
		public Account getAccountByUsername(String username) {
			EntityManager em = emf.createEntityManager();
			@SuppressWarnings("unchecked")
			List<Account> accs = (List<Account>) em.createNamedQuery("Account.getByUsername").setParameter("username", username)
					.getResultList();
			em.close();

			// GET the first account with that id
			Account acc = null;
			for (Account a : accs) {
				acc = a;
			}

			return acc;
		}
}
