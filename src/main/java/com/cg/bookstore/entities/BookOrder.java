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
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "bookordertable")
public class BookOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookorder_id")
	private int orderId;

	@OneToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;

	@Column(name = "orderdate")
	private LocalDate orderDate;

	@Column(name = "ordertotal")
	private double orderTotal;

	@Column(name = "status")
	private String status;

	@OneToOne
	@JoinColumn(name = "shippingaddress")
	private Address shippingAddress;

	@Column(name = "paymentmethod")
	private String paymentMethod;

	@Column(name = "recipentname")
	private String recipientName;

	@Column(name = "recipentphone")
	@Pattern(regexp = "(0/91)?[7-9][0-9]{9}", message = "mobile number must be 10 digit")
	private String recipientPhone;
	
	
	public BookOrder() {
		super();
	}

	public BookOrder(int orderId, Customer customer, LocalDate orderDate, double orderTotal, String status,
			Address shippingAddress, String paymentMethod, String recipientName,String recipientPhone,
			OrderDetails details) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
		this.status = status;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.recipientName = recipientName;
		this.recipientPhone = recipientPhone;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientPhone() {
		return recipientPhone;
	}

	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}


	
}
