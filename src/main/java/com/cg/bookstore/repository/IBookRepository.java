package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Category;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

	@Query("select b from Book b where b.title=?1")
	public Book findByTitle(String title);

	@Query("select c from Category c where c.categoryName=?1")
	public List<Category> findByCategory(String categoryName);

	@Query("select distinct(title) from Book")
	public List<Book> findByBestSellingBook();


}