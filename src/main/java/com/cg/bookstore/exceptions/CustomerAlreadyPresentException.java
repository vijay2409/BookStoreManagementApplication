package com.cg.bookstore.exceptions;

public class CustomerAlreadyPresentException extends RuntimeException {

	public CustomerAlreadyPresentException(String message) {
		super(message);
	}

}
