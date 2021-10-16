package com.nive.springdemo.dao;

import java.util.List;

import com.nive.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	 public int addCustomerDao(Customer customer);

	public Customer getCustomerById(int id);

	public void UpdateCustomer(Customer theCustomer);

	public void deleteCustomer(Customer theCustomer);

	public List<Customer> searchCustomer(String searchName);
}
