package com.cg.bookstore.services;

import java.util.List;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Review;

public interface IReviewService {

	public List<Review> listAllReviews();

	public Review addReview(Review review);

	public String deleteReview(Integer reviewId);

	public Review updateReview(Review review);

	public List<Review> listMostFavoredBooks(double rating);

	public Review viewReview(Integer reviewId);

	public List<Review> listAllReviewsByBook(Book book);

	public List<Review> listAllReviewsByCustomer(int customerId);
}
