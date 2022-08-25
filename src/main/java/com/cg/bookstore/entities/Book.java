package com.cg.bookstore.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "booktable")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "book_id", unique = true)
	private int bookId;

	@NotEmpty
	@Column(unique = true)
	@Size(min = 3)
	private String title;

	@Column(name = "author")
	@NonNull
	@Size(min = 3)
	private String author;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoryId")
	private Category category;

	@Column(name = "description")
	private String description;

	@Column(name = "isbn")
	@NonNull
	@Pattern(regexp = "^(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$", message = "enter a valid isbn")
	private String isbn;

	@Column(name = "price")
	@NonNull
	private double price;

	@Column(name = "publishdate")
	@NonNull
	private LocalDate publishDate;

	@Column(name = "lastupdatedon")
	private LocalDate lastUpdatedOn;

//	@OneToOne(mappedBy = "book")
//	private OrderDetails details;

	public Book() {
	}

	public Book(int bookId,String title, @Size(min = 3) String author, Category category,
			String description,
			@Pattern(regexp = "^(?=[0-9]{13}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)97[89][- ]?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9]$", message = "enter a valid isbn") String isbn,
			double price, LocalDate publishDate, LocalDate lastUpdatedOn) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.category = category;
		this.description = description;
		this.isbn = isbn;
		this.price = price;
		this.publishDate = publishDate;
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDate getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}

	public LocalDate getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(LocalDate lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

}
