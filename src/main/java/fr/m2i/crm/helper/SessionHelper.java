package fr.m2i.crm.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionHelper {
	private static EntityManager entityManager;
	
	
	// A éviter car bouffe de la mémoire pour stocker cette info qui ne sert qu'à une reprise
	// private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm");
	
	private SessionHelper() {};
	
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm");
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}
}
