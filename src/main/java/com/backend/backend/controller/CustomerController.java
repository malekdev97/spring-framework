package com.backend.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.backend.backend.entity.Customer;
import com.backend.backend.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping(value = "/customer", method = RequestMethod.GET)
public class CustomerController {
	
				// 0- Inject Service in the Service 
				@Autowired
				private CustomerService customerService;
				
				@GetMapping("/test")
				public String index() {
					return "Greetings from Customer API!";
				}
				
				
				
				
				// 1 : create customer
				@PostMapping("/new")
				public ResponseEntity<Object> createCustomer(@Valid @RequestBody Customer customer) {
					Customer savedCustomer = customerService.createCustomer(customer);
					System.out.println(savedCustomer);
					return ResponseEntity.ok("Customer with id " + customer.getId() + " successfully added ");
//					return customerService.createCustomer(customer);
				}
				
				
				
				
				// 2 : get customer
				@GetMapping("/get/{id}")
				public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id) {
					Customer fetchResult = customerService.getCustomerById(id);
					if(fetchResult == null) {
						return null;
					}
					return ResponseEntity.ok(fetchResult);
//					return customerService.getCustomerById(id);
				}

				// 3 : update customer
				@PutMapping("/update/{id}")
				public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id, @Valid @RequestBody Customer customer) {
					customerService.updateCustomer(id, customer);
					return ResponseEntity.ok("Customer with Id : " + id +" has been updateed successfully");
//					return customerService.updateCustomer(customerId ,updatedCustomer);
				}

				// 4 : delete customer
				@DeleteMapping("/delete/{id}")
				public ResponseEntity<Object> deleteCustomer(@PathVariable("id") Long id) {
					customerService.deleteCustomer(id);
					return ResponseEntity.ok("Customer with Id : " + id +" has been deleted successfully");
				}
				
				// 5 : get all customers
				@GetMapping("/get/all")
				public ResponseEntity<Object> getAllCustomers() {
					List<Customer> fetchResult = customerService.getAllCustomers();
					return ResponseEntity.ok(fetchResult);
				}
				
				
	
	
	

}
