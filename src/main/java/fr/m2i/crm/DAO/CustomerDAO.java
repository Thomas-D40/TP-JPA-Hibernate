package fr.m2i.crm.DAO;

import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;
import fr.m2i.crm.state.CustomerState;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;


public class CustomerDAO {
	
	public ArrayList<Customer> findAllCustomers() {
		EntityManager entityManager = SessionHelper.getEntityManager();
		
		Query query = entityManager.createQuery("SELECT * FROM customers");
		
		return (ArrayList<Customer>) query.getResultList();
		
	}
	
	public Customer findById(Long id) {
		EntityManager entityManager = SessionHelper.getEntityManager();
		
		Customer customer = entityManager.find(Customer.class, id);
		
		if (customer == null) {
			System.out.println("Aucun utilisateur trouvé");
		}
		return customer;
		
	}
	
	public void create(Customer customer) {
		
		if (customer == null) {
			System.out.println("Une erreur est survenue lors de la création");
			return;
		}
		
		EntityManager entityManager = SessionHelper.getEntityManager();
		
		
		
		
		
		EntityTransaction tx = null;
		
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.persist(customer);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Une erreur est survenue");
			if (tx != null) {
				tx.rollback();
			}
			
		}
	}
	
	public void update(Customer customer) {
		
		if (customer == null) {
			System.out.println("Une erreur est survenue lors de la mise à jour");
			return;
		}
		
		EntityManager entityManager = SessionHelper.getEntityManager();
		
		
		
		Customer customerToUpdate = findById(customer.getId());
		
		
		if (customerToUpdate == null) {
			System.out.println("Aucun utilisateur ne correspond à cet Id");
			return;
		}
		
		customerToUpdate.setNotNullData(customer);
		
		EntityTransaction tx = null;
		
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.merge(customerToUpdate);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Une erreur est survenue");
			if (tx != null) {
				tx.rollback();
			}
		}
	}
	
	public void delete(Customer customer) {
		
		
		if (customer == null) {
			System.out.println("Une erreur est survenue lors de la suppression");
			return;
		}
		
		EntityManager entityManager = SessionHelper.getEntityManager();
		
		
		EntityTransaction tx = null;
		
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			entityManager.remove(customer);
			tx.commit();
		} catch (Exception e) {
			System.out.println("Une erreur est survenue!");
			if (tx != null) {
				tx.rollback();
			}
		}
	}
}
