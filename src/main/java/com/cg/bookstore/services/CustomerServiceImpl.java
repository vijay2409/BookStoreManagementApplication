package com.cg.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.exceptions.CustomerAlreadyPresentException;
import com.cg.bookstore.exceptions.CustomerNotFoundException;
import com.cg.bookstore.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer){
		if(customer!=null) {
			return customerRepository.save(customer);
		}else
			throw new CustomerAlreadyPresentException("Customer already exists");
	}

	@Override
	public List<Customer> listCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public String deleteCustomer(Integer customerId) {
		Customer findCustomerById = customerRepository.findById(customerId).get();
		if (findCustomerById != null) {
			customerRepository.deleteById(customerId);
			return "customer deleted";
		} else {
			throw new CustomerNotFoundException("Customer does not exist");
		}
	}

	@Override
	public Customer viewCustomer(int customerId) {
		Customer findBookById = customerRepository.findById(customerId).get();
		if (findBookById != null) {
			return findBookById;
		} else
			throw new CustomerNotFoundException("Customer with Id " + customerId + " not exists");
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer findBookById = customerRepository.findById(customer.getCustomerId()).get();
		if (findBookById != null) {
			customerRepository.save(customer);
			return customer;
		} else
			throw new CustomerNotFoundException("Customer with Id " + customer.getCustomerId() + " not exists");
	}

	@Override
	public List<Book> listAllCustomersByBook(Book title) {
		return customerRepository.findByBook(title);
	}

}
