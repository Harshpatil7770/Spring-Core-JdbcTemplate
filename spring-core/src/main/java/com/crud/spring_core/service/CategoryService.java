package com.crud.spring_core.service;

import java.util.List;

import com.crud.spring_core.model.Category;

public interface CategoryService {

	String addNewCategory(Category category);

	String updateCategory(Category category);

	Category fetchById(int categoryId);

	List<Category> fetchAllCategories();
	
	boolean deleteCategory(int categoryId);
}
