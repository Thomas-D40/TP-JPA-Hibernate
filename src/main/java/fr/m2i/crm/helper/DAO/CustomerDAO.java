package fr.m2i.crm.helper.DAO;

import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


public class CustomerDAO {
	
	private final EntityManager entityManager = SessionHelper.getEntityManager();
	
	public List findAll() {
		
		Query query = entityManager.createQuery("SELECT c FROM Customer c");
		
		return query.getResultList();
		
	}
	
	public Customer findById(Long id) {
		
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
