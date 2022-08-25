package com.cg.bookstore.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="reviewtable")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="review_id")
	private int reviewId;
	
	@OneToOne
    @JoinColumn(name="book_id")
	private Book book;
	
	@OneToOne
	@JoinColumn(name="cust_id")
    private Customer customerId;
    
	@Column(name="headline")
	private String headLine;
	
	@Column(name="comments")
	private String comment;
	
	@Column(name="ratings")
	@NonNull
	private double rating;
	
	@Column(name="date_reviewon")
	private LocalDate reviewOn;
	
	@OneToOne
	private Customer customer;

	public Review() {
		super();
	}

	public Review(int reviewId, Book book, Customer customerId, String headLine, String comment, double rating,
			LocalDate reviewOn, Customer customer) {
		super();
		this.reviewId = reviewId;
		this.book = book;
		this.customerId = customerId;
		this.headLine = headLine;
		this.comment = comment;
		this.rating = rating;
		this.reviewOn = reviewOn;
		this.customer = customer;
	}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public String getHeadLine() {
		return headLine;
	}

	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public LocalDate getReviewOn() {
		return reviewOn;
	}

	public void setReviewOn(LocalDate reviewOn) {
		this.reviewOn = reviewOn;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	

	

	
	
}
