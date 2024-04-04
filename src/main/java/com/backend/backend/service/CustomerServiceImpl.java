package com.backend.backend.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.entity.Branch;
import com.backend.backend.entity.Customer;
import com.backend.backend.repository.CustomerRepository;

import jakarta.validation.Valid;
@Service
public class CustomerServiceImpl implements CustomerService{
	
			// 1- inject Repository in the Service 
			@Autowired
			private CustomerRepository customerRepository;

			
			
			
			@Override
			public Customer createCustomer(Customer customer) {
				return customerRepository.save(customer);
			}

			@Override
			public Customer getCustomerById(@Valid Long id) {
				
				Optional<Customer> customer = customerRepository.findById(id);
				if(!customer.isPresent()) {
					System.out.println("Customer with id " + id + " doesn't Exist ");
					return null;
				}
				System.out.println("Customer with id " + id + " is : " + customer.toString());
				return customer.get();
//				return customerRepository.findById(id).get();
			}

		
			@Override
			public Customer updateCustomer(Long id, Customer customer) {
				
				Customer customerFromDB = customerRepository.findById(id).get();
				
				// New Value :
				String customerName = customer.getName();
				String customerUsername = customer.getUsername();	
				String customerEmail = customer.getEmail();
				String customerPhone = customer.getPhone();	
				String customerPassword = customer.getPassword();

				
				// Print The Checks
				System.out.println(Objects.nonNull(customerName));
				System.out.println("".equalsIgnoreCase(customerName));
				System.out.println(!"".equalsIgnoreCase(customerName));
				
				// Null and Blank checks of the new values 
				if(Objects.nonNull(customerName) && !"".equalsIgnoreCase(customerName)) {
					customerFromDB.setName(customerName);
				}
				if(Objects.nonNull(customerUsername) && !"".equalsIgnoreCase(customerUsername)) {
					customerFromDB.setUsername(customerUsername);
				}
				
				if(Objects.nonNull(customerEmail) && !"".equalsIgnoreCase(customerEmail)) {
					customerFromDB.setEmail(customerEmail);
				}
				
				if(Objects.nonNull(customerPhone) && !"".equalsIgnoreCase(customerPhone)) {
					customerFromDB.setPhone(customerPhone);
				}
				
				if(Objects.nonNull(customerPassword) && !"".equalsIgnoreCase(customerPassword)) {
					customerFromDB.setPassword(customerPassword);
				}
				
				return customerRepository.save(customerFromDB);
			}

			

			@Override
			public void deleteCustomer(Long id) {
				customerRepository.deleteById(id);
				
			}

			@Override
			public List<Customer> getAllCustomers() {
				return customerRepository.findAll();
			}
			

}
