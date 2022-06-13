package fr.m2i.crm.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionHelper {
	private static EntityManager entityManager;
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm");
	
	private SessionHelper() {};
	
	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = emf.createEntityManager();
		}
		return entityManager;
	}
}
