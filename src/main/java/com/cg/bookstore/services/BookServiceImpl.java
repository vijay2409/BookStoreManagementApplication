package com.cg.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Category;
import com.cg.bookstore.exceptions.BookAlreadyPresentException;
import com.cg.bookstore.exceptions.BookNotFoundException;
import com.cg.bookstore.repository.IBookRepository;

@Service
public class BookServiceImpl implements IBookService {
	@Autowired
	private IBookRepository bookRepository;

	@Override
	public Book createBook(Book book) {
		if (book != null) {
			return bookRepository.save(book);
		} else
			throw new BookAlreadyPresentException("Book  already exists");
	}

	@Override
	public List<Book> listAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book deleteBook(int bookId) {
		Book deleteBook = null;
		try {
			deleteBook = bookRepository.findById(bookId).orElse(null);
			if (deleteBook == null) {
				throw new BookNotFoundException("book not avilable");
			} else {
				bookRepository.deleteById(bookId);
			}
		} catch (BookNotFoundException e) {
			throw e;
		}
		return deleteBook;
	}

	@Override
	public ResponseEntity<Book> editBook(Book book, int bookId) {
		Book b=bookRepository.findById(bookId)
				.orElseThrow(()-> new BookNotFoundException("Book not exist with bookId"+bookId));
		b.setTitle(book.getTitle());
		b.setAuthor(book.getAuthor());
		b.setCategory(book.getCategory());
		b.setDescription(book.getDescription());
		b.setIsbn(book.getIsbn());
		b.setPrice(book.getPrice());
		b.setPublishDate(book.getPublishDate());
		b.setLastUpdatedOn(book.getLastUpdatedOn());
		Book editBook= bookRepository.save(b);
		return ResponseEntity.ok(editBook);
	}

	@Override
	public Book viewBook(String title) {
		return bookRepository.findByTitle(title);
	}

	@Override
	public List<Category> listBooksByCategory(String categoryName) {
		return bookRepository.findByCategory(categoryName);
	}

	@Override
	public List<Book> listBestSellingBook() {
		return bookRepository.findByBestSellingBook();
	}

}
