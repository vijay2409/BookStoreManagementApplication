package com.cg.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bookstore.entities.Category;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

	@Query("select c from Category c where c.categoryName=?1")
	public Category findByCategoryName(String categoryName);

	public String save(String categoryName);

}