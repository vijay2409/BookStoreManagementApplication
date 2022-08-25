package com.cg.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.BookOrder;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.entities.OrderDetails;
import com.cg.bookstore.repository.IOrderDetailsRepository;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {

	@Autowired
	private IOrderDetailsRepository orderDetailsRepository;

	@Override
	public List<OrderDetails> listAllOrders() {
		return orderDetailsRepository.findAll();
	}

	@Override
	public List<Customer> listOrderByCustomer(int customerId) {
		return orderDetailsRepository.findByCustomer(customerId);
		
	}

	@Override
	public BookOrder viewOrderForCustomer(int customerId) {
		return orderDetailsRepository.findByCustomerId(customerId);
	}

//	@Override
//	public OrderDetails viewOrderForAdmin(int orderDetailsId) {
//		return orderDetailsRepository.findByAdmin(orderDetailsId);
//	}

	@Override
	public BookOrder cancelOrder(int orderId) {
		return orderDetailsRepository.deleteByOrderId(orderId);
	}

	@Override
	public OrderDetails addOrder(OrderDetails od) {
		return orderDetailsRepository.save(od);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails od) {
		return orderDetailsRepository.save(od);
	}

	@Override
	public List<Book> viewOrderByBook(int bookId) {
		return orderDetailsRepository.findByBookId(bookId);
	}

}
