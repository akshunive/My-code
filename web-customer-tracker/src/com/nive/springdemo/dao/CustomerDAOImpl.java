package com.nive.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nive.springdemo.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Customer> q = session.createQuery("from Customer order by firstName",Customer.class);
		List<Customer> customerList= q.getResultList();
		
		
		return customerList;
	}

	@Override
	public int addCustomerDao(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(customer);
		return 0;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		System.out.println("DAO   " +customer.getLastName());
		
		return customer;
	}

	@Override
	public void UpdateCustomer(Customer theCustomer) {
		Session session = sessionFactory.getCurrentSession();
		/*
		 * 
		 * We can use this
		 * 
		 * 
		 * Query<Customer> q = session.
		 * createQuery("update Customer set firstName= :f, lastName= :l, email= :e where id= :i"
		 * ,Customer.class); q.setParameter("f", theCustomer.getFirstName());
		 * q.setParameter("l", theCustomer.getLastName()); q.setParameter("e",
		 * theCustomer.getEmail()); q.setParameter("i", theCustomer.getId()); int result
		 * = q.executeUpdate();
		 */
		
		/*
		 * 
		 * we can use SaveOrUpdate(customer); // either inserts or updates depending on whether the primary feild is present or not 
		 * 
		 * 
		 */
		
		session.update(theCustomer);
	}

	@Override
	public void deleteCustomer(Customer theCustomer) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(theCustomer);
		
	}

	@Override
	public List<Customer> searchCustomer(String searchName) {
		Session session = sessionFactory.getCurrentSession();
		System.out.println("dao :"+searchName);
		Query<Customer> q = session.createQuery("FROM Customer where lower(firstName) LIKE :theSearchName OR lower(lastName) like :theSearchName", Customer.class);
		q.setParameter("theSearchName", "%"+searchName.toLowerCase()+"%");
		List<Customer> searchCustomers = q.getResultList();
		return searchCustomers;
	}

}
