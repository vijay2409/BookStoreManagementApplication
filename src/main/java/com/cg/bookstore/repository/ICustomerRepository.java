package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("select b from Book b where b.title=?1")
	List<Book> findByBook(Book title);


}