package com.cg.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cg.bookstore.entities.Book;
import com.cg.bookstore.entities.Review;

public interface IReviewRepository extends JpaRepository<Review, Integer> {

	@Query("select r from Review r where r.rating=?1")
	public List<Review> findListMostFavBooks(double rating);

	@Query("select r from Review r where r.reviewId=?1")
	public Review findById(Review reviewId);

	@Query("select r from Review r where r.customerId=?1")
	public List<Review> listAllReviewsByCustomer(int customerId);

	@Query("select r from Review r where r.book=?1")
	public List<Review> listAllReviewsByBook(Book book);

}
