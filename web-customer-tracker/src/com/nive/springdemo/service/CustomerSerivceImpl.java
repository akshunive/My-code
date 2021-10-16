package com.nive.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nive.springdemo.dao.CustomerDAO;
import com.nive.springdemo.entity.Customer;

@Service
public class CustomerSerivceImpl implements CustomerSerivce {

	@Autowired
	private CustomerDAO dao;
	
	@Override
	@Transactional
	public List<Customer> getCustomersService() {
		
		List<Customer> customers =dao.getCustomers();
		
		
		return customers;
	}

	@Override
	@Transactional
	public int addCustomerService(Customer customer) {
		int result = dao.addCustomerDao(customer);
		return result;
	}

	@Override
	@Transactional
	public Customer getCustomerByIdService(int id) {
		Customer customer = dao.getCustomerById(id);
		System.out.println("Service   " +customer.getLastName());
		return customer;
	}

	@Override
	@Transactional
	public void updateCustomerService(Customer theCustomer) {
		 dao.UpdateCustomer(theCustomer);
		 
	}

	@Override
	@Transactional
	public void deleteCustomerService(Customer theCustomer) {
		dao.deleteCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomerService(String searchName) {
		List<Customer> searchCustomers = dao.searchCustomer(searchName);
		return searchCustomers;
	}

}
