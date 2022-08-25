package com.cg.bookstore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int categoryId;

	@Column(name = "category_name")
	@NonNull
	private String categoryName;

	@OneToOne(mappedBy = "category")
	private Book book;

	public Category() {
		super();
	}

	public Category(int categoryId, String categoryName, Book book) {
		super();
		this.categoryId = categoryId;
		this.categoryName=categoryName;
		this.book=book;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


}
