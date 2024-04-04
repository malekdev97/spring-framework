package com.backend.backend.service;

import java.util.List;
import java.util.Optional;

import com.backend.backend.entity.Customer;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer);
	public Customer getCustomerById(Long id);
	public Customer updateCustomer(Long id, Customer customer);
	public void deleteCustomer(Long id);
	public List<Customer> getAllCustomers();

}
