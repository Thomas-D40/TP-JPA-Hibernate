package fr.m2i.crm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("crm"); // Point d'entrée pour créer des requêtes
		EntityManager entityManager = emf.createEntityManager();
	
	}
}