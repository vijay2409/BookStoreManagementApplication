package com.cg.bookstore.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orderdetailstable")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "orderdetails_id", nullable = false)
	private int orderDetailsId;

	@OneToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bookorder_id")
	private BookOrder bookOrder;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "subtotal")
	private double subtotal;

	OrderDetails() {
		super();
	}

	public OrderDetails(int orderDetailsId, Book book, BookOrder bookOrder, int quantity, double subtotal) {
		super();
		this.orderDetailsId = orderDetailsId;
		this.book = book;
		this.bookOrder = bookOrder;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public int getOrderDetailsId() {
		return orderDetailsId;
	}

	public void setOrderDetailsId(int orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public BookOrder getBookOrder() {
		return bookOrder;
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}
