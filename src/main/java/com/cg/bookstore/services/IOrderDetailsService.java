package com.cg.bookstore.services;

import java.util.List;


import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.BookOrder;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.entities.OrderDetails;

public interface IOrderDetailsService {

	public List<OrderDetails> listAllOrders();

	public List<Customer> listOrderByCustomer(int customerId);

	public BookOrder viewOrderForCustomer(int customerId);

//	public OrderDetails viewOrderForAdmin(int orderDetailsId);

	public BookOrder cancelOrder(int orderId);

	public OrderDetails addOrder(OrderDetails od);

	public OrderDetails updateOrder(OrderDetails od);

	public List<Book> viewOrderByBook(int bookId);

}
