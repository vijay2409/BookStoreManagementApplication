package com.cg.bookstore.services;

import java.util.List;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Customer;

public interface ICustomerService {

	public Customer createCustomer(Customer customer);

	public List<Customer> listCustomers();

	public String deleteCustomer(Integer customerId);

	public Customer viewCustomer(int customerId);

	public Customer updateCustomer(Customer customer);

	public List<Book> listAllCustomersByBook(Book book);

}
