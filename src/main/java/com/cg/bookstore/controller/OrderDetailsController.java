package com.cg.bookstore.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.BookOrder;
import com.cg.bookstore.entities.OrderDetails;
import com.cg.bookstore.exceptions.OrderListEmptyException;
import com.cg.bookstore.services.IOrderDetailsService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class OrderDetailsController {

	
	@Autowired
	private IOrderDetailsService orderDetailsService;

	@GetMapping("/orders")
	public List<OrderDetails> listAllOrders() {
		return orderDetailsService.listAllOrders();
	}

	@PostMapping("/orders")
	public OrderDetails addOrder(@RequestBody OrderDetails od) {
		return orderDetailsService.addOrder(od);
	}
	
	@GetMapping("/orders/{customerId}")
	@ExceptionHandler(OrderListEmptyException.class)
	public BookOrder viewOrderForCustomer(@PathVariable int customerId) {
		return orderDetailsService.viewOrderForCustomer(customerId);
	}
	
//	@GetMapping("/vieworderforadmin/{orderDetailsId}")
//	public OrderDetails viewOrderForAdmin(@PathVariable int orderDetailsId) {
//		return orderDetailsService.viewOrderForAdmin(orderDetailsId);
//	}
	
	@DeleteMapping("/orders/{orderId}")
	public BookOrder cancelOrder(@PathVariable int orderId) {
		return orderDetailsService.cancelOrder(orderId);
	}
	
//	@GetMapping("/listorderbycustomer")
//	public List<Customer> listOrderByCustomer(@PathVariable int customerId){
//		return orderDetailsService.listOrderByCustomer(customerId);
//	}
	
	@PutMapping("/orders")
	public OrderDetails updateOrder(@RequestBody OrderDetails od) {
		return orderDetailsService.updateOrder(od);
	}
	
	@GetMapping("/orders/{book}")
	public List<Book> viewOrderByBook(@PathVariable int bookId){
		return orderDetailsService.viewOrderByBook(bookId);
	}
}
