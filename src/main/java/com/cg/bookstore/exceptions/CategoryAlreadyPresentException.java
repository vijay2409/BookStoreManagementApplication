package com.cg.bookstore.exceptions;

public class CategoryAlreadyPresentException extends RuntimeException {

	public CategoryAlreadyPresentException(String message) {
		super(message);
	}

}
