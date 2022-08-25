package com.cg.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Review;
import com.cg.bookstore.exceptions.ReviewNotFoundException;
import com.cg.bookstore.services.IReviewService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class ReviewController {

	@Autowired
	private IReviewService reviewService;

	@PostMapping("/reviews")
	public Review addReview(@Valid @RequestBody Review review) {
		return reviewService.addReview(review);
	}

	@GetMapping("/reviews")
	public List<Review> getAllReview() {
		return reviewService.listAllReviews();
	}

	@PutMapping("/reviews")
	public Review updateReview(@RequestBody Review review) {
		return reviewService.updateReview(review);
	}

	@DeleteMapping("/reviews/{reviewId}")
	public String deleteReviewByReviewID(@PathVariable Integer reviewId) {
		return reviewService.deleteReview(reviewId);
	}

	@GetMapping("/reviews/{reviewId}")
	@ExceptionHandler(ReviewNotFoundException.class)
	public Review viewReviewByReviewId(@PathVariable int reviewId) {
		return reviewService.viewReview(reviewId);
	}

	@GetMapping("/reviews/{book}")
	public List<Review> getAllReviewByBook(@RequestBody Book book) {
		return reviewService.listAllReviewsByBook(book);
	}

	@GetMapping("/reviews/{customerId}")
	public List<Review> getAllReviewByCustomer(@PathVariable int customerId) {
		return reviewService.listAllReviewsByCustomer(customerId);
	}

	@GetMapping("/reviews/{rating}")
	public List<Review> listMostFavoredBooks(double rating) {
		return reviewService.listMostFavoredBooks(rating);
	}

}
