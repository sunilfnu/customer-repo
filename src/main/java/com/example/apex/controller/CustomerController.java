package com.example.apex.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.apex.model.Customer;
import com.example.apex.repository.CustomerRepository;
/**
 * The REST APIS you should 
-	Create A Customer
-	Retrieve A Customer By Id
-	Update A Customer (change emailId)
-	Delete A Customer By Id
-	Retrieve All Customers done
-	BONUS:  Retrieve All Customers By Last Name

 	HOSTURL: localhost
    PORT: 8080
 	REQUEST MAPPING: /api/v1/customers/10001
 	METHOD : GET

 * @author rubin
 *
 */
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	private final CustomerRepository repo;

	public CustomerController(CustomerRepository repository) {
		this.repo = repository;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer createCustomer(@RequestBody Customer newCustomer) {
		logger.debug("Inside the createCustomer conflict!!!");
		return this.repo.save(newCustomer);
	}
	
	@PutMapping
	public Customer updateCustomer(@RequestBody Customer newCustomer) {
		logger.debug("Inside updateCustomer method!!!");
		return this.repo.save(newCustomer);
	}
	
	@GetMapping("/{id}")
	public Customer getById(@PathVariable Long id) {
		return this.repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		this.repo.deleteById(id);
	}

	@GetMapping
	public List<Customer> getAll() {
		return this.repo.findAll();
	}
}
