package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.BookOrder;
import com.cg.bookstore.entities.Customer;
import com.cg.bookstore.entities.OrderDetails;

public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

	public List<OrderDetails> findAll();

	@Query("select c from Customer c where c.customerId=?1")
	public List<Customer> findByCustomer(int customerId);

	@Query("select bo from BookOrder bo where bo.customer=?1")
	public BookOrder findByCustomerId(int customer);

//	@Query("select od from OrderDetails od where od.orderDetailsId=?1")
//	public OrderDetails findByAdmin(int orderDetailsId);

	@Query("select bo from BookOrder bo where bo.orderId=?1")
	public BookOrder deleteByOrderId(int orderId);

	@Query("select b from Book b where b.bookId=?1")
	public List<Book> findByBookId(int bookId);

}
