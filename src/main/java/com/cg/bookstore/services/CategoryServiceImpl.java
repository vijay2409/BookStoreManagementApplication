package com.cg.bookstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookstore.entities.Category;
import com.cg.bookstore.exceptions.CategoryAlreadyPresentException;
import com.cg.bookstore.exceptions.CategoryNotFoundException;
import com.cg.bookstore.repository.ICategoryRepository;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private ICategoryRepository categoryRepository;

	@Override
	public String addCategory(String category) {
		Category findCategoryByCategoryName = categoryRepository.findByCategoryName(category);
		if (findCategoryByCategoryName != null) {
			return categoryRepository.save(category);
		} else
			throw new CategoryAlreadyPresentException("Category " + category + " already exists");
	}

	@Override
	public Category editCategory(Category category) {
		Category findCategoryByCategoryName = categoryRepository.findById(category.getCategoryId()).get();
		if (findCategoryByCategoryName != null) {
			categoryRepository.save(category);
			return category;
		} else
			throw new CategoryNotFoundException("Category with Id " + category.getCategoryId() + " not exists");
	}

	@Override
	public List<Category> viewAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public String removeCategory(Integer categoryId) {
		Category findBookingByCategoryId = categoryRepository.findById(categoryId).get();
		if (findBookingByCategoryId != null) {
			categoryRepository.deleteById(categoryId);
			return "Category Deleted";
		} else
			throw new CategoryNotFoundException("Category not found for the entered categoryName");
	}
	
	

}
