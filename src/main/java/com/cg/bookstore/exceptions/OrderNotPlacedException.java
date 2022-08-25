package com.cg.bookstore.exceptions;

public class OrderNotPlacedException extends RuntimeException {

	public OrderNotPlacedException(String message) {
		super(message);
	}

}
