package fr.m2i.crm;

import fr.m2i.crm.helper.DAO.CustomerDAO;
import fr.m2i.crm.helper.SessionHelper;
import fr.m2i.crm.model.Customer;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;


public class Main {
	public static void main(String[] args) {

		EntityManager entityManager = SessionHelper.getEntityManager();
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		/* Customer customerWithId1 = new Customer();
		customerWithId1.setId(1L);
		customerWithId1.setFirstName("Tommy");
		customerDAO.update(customerWithId1); */
		
		List<Customer> customers = customerDAO.findAll();
		for (Customer customer:customers) {
			System.out.println(customer);
		}
		
		entityManager.close();
	
	}
}