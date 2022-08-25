package com.cg.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.services.ICustomerService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> listCustomers(){
		return customerService.listCustomers();
	}
	
	@PostMapping("/customers")
	ResponseEntity<String> createCustomer(@Valid @RequestBody Customer customer){
		customerService.createCustomer(customer);
//		System.out.println("customer added successfully");
		return ResponseEntity.ok("customer " + customer.getFullName() + " is valid");
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable Integer customerId) {
		return customerService.deleteCustomer(customerId);
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer viewCustomer(@PathVariable int customerId) {
		return customerService.viewCustomer(customerId);
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		return customerService.updateCustomer(customer);
	}
	
	//not working
	@GetMapping("/customers/{title}")
	public List<Book> listAllCustomersByBook(@PathVariable Book title){
		return customerService.listAllCustomersByBook(title);
	}
	

}
