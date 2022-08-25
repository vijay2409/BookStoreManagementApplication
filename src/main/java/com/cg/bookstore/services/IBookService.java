package com.cg.bookstore.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Category;
import com.cg.bookstore.exceptions.BookAlreadyPresentException;
import com.cg.bookstore.exceptions.BookNotFoundException;
import com.cg.bookstore.exceptions.CategoryNotFoundException;


public interface IBookService {

	public Book createBook(Book book) throws BookAlreadyPresentException;

	public List<Book> listAllBooks() throws BookNotFoundException;

	public Book deleteBook(int bookId) throws BookNotFoundException;

	public ResponseEntity<Book> editBook(Book book, int bookId) throws BookAlreadyPresentException;

	public Book viewBook(String title) throws BookNotFoundException;

	public List<Category> listBooksByCategory(String categoryName) throws CategoryNotFoundException;

	public List<Book> listBestSellingBook() throws BookNotFoundException;

}