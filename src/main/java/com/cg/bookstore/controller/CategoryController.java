package com.cg.bookstore.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookstore.entities.Category;
import com.cg.bookstore.services.ICategoryService;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class CategoryController {
	
	@Autowired 
	private ICategoryService categoryService;
	
	@PostMapping("/category")
	public String addCategory(@Valid @RequestBody String category) {
		return categoryService.addCategory(category);
	}
	
	@PutMapping("/category")
	public Category editCategory(@RequestBody Category category) {
		return categoryService.editCategory(category);
	}
	
	@GetMapping("/category")
	public List<Category> viewAllCategories(){
		return categoryService.viewAllCategories();
	}
	
	@DeleteMapping("/category/{categoryId}")
	public String removeCategory(@PathVariable Integer categoryId) {
		return categoryService.removeCategory(categoryId);
	}

}
