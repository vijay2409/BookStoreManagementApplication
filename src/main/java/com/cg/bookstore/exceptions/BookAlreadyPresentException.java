package com.cg.bookstore.exceptions;

public class BookAlreadyPresentException extends RuntimeException{


	public BookAlreadyPresentException(String message) {
		super(message);
	}

}
