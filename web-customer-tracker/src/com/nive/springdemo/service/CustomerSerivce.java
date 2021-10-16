package com.nive.springdemo.service;

import java.util.List;

import com.nive.springdemo.entity.Customer;

public interface CustomerSerivce {

	public List<Customer> getCustomersService();

	public int addCustomerService(Customer customer);

	public Customer getCustomerByIdService(int id);

	public void updateCustomerService(Customer theCustomer);

	public void deleteCustomerService(Customer theCustomer);

	public List<Customer> searchCustomerService(String searchName);
}
