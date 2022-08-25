package com.cg.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.cg.bookstore.entities.Category;
import com.cg.bookstore.exceptions.BookAlreadyPresentException;
import com.cg.bookstore.exceptions.BookNotFoundException;
import com.cg.bookstore.services.IBookService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class BookController {

	@Autowired
	private IBookService bookService;

//	Working
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book book1 = null;
		try {
			book1 = bookService.createBook(book);
		} catch (BookAlreadyPresentException e) {
			e.getMessage();
		}
		return new ResponseEntity<>(book1, HttpStatus.OK);
	}

//	Working
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> book = null;
		try {
			book = bookService.listAllBooks();
		} catch (BookNotFoundException e) {
			e.getMessage();
		}
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	@GetMapping("/books/{category}")
	public List<Category> getBookByCategory(@PathVariable("category") String bookCategory) {
		return bookService.listBooksByCategory(bookCategory);
	}

//	Working
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> editBook(@PathVariable int bookId, @RequestBody Book book) {
		return bookService.editBook(book, bookId);
	}

//	Working
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Book> deleteBook(@PathVariable int bookId) {
		Book book = null;
		try {
			book = bookService.deleteBook(bookId);
		} catch (BookNotFoundException e) {
			e.getMessage();
		}
		return new ResponseEntity<>(book, HttpStatus.OK);
	}

	// not working
	@GetMapping("/listBestSellingBook")
	public List<Book> listBestSellingBook() {
		return bookService.listBestSellingBook();
	}

}
