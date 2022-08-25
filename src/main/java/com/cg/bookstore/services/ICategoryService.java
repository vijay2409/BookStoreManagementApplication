package com.cg.bookstore.services;

import java.util.List;

import com.cg.bookstore.entities.Category;
import com.cg.bookstore.exceptions.CategoryAlreadyPresentException;
import com.cg.bookstore.exceptions.CategoryNotFoundException;


public interface ICategoryService {

	public String addCategory(String category) throws CategoryAlreadyPresentException;

	public Category editCategory(Category category) throws CategoryNotFoundException;

	public List<Category> viewAllCategories() throws CategoryNotFoundException;

	public String removeCategory(Integer categoryId) throws CategoryNotFoundException;
}