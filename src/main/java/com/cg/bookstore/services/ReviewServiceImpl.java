package com.cg.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Review;
import com.cg.bookstore.exceptions.ReviewNotFoundException;
import com.cg.bookstore.repository.IReviewRepository;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private IReviewRepository reviewServiceRepo;

	@Override
	public List<Review> listAllReviews() {
		return reviewServiceRepo.findAll();
	}

	@Override
	public Review addReview(Review review) {
		return reviewServiceRepo.save(review);
	}

	@Override
	public String deleteReview(Integer reviewId) {
		Review findReviewById = reviewServiceRepo.findById(reviewId).get();
		if (findReviewById != null) {
			reviewServiceRepo.deleteById(reviewId);
			return "Review Deleted!!";
		} else
			throw new ReviewNotFoundException("Review not found for the entered ReviewID");
	}

	@Override
	public Review updateReview(Review review) {
		Review findReviewById = reviewServiceRepo.findById(review.getReviewId()).get();
		if (findReviewById != null) {
			reviewServiceRepo.save(review);
			return review;
		} else
			throw new ReviewNotFoundException("Review with Id: " + review.getReviewId() + " not exists!!");
	}

	@Override
	public List<Review> listMostFavoredBooks(double rating) {
		return reviewServiceRepo.findListMostFavBooks(rating);
	}

	@Override
	public Review viewReview(Integer reviewId) {
		Optional<Review> findReviewById = reviewServiceRepo.findById(reviewId);
		if (findReviewById.isPresent()) {
			return findReviewById.get();
		} else
			throw new ReviewNotFoundException("Review not found for the entered ReviewID");
	}

	@Override
	public List<Review> listAllReviewsByBook(Book book) {
		return reviewServiceRepo.listAllReviewsByBook(book);
	}

	@Override
	public List<Review> listAllReviewsByCustomer(int customerId) {
		return reviewServiceRepo.listAllReviewsByCustomer(customerId);
	}

}
