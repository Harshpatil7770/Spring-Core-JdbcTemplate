package com.crud.spring_core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.spring_core.dao.CategoryDao;
import com.crud.spring_core.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryDao categoryDao;

	@Override
	public String addNewCategory(Category category) {
		return categoryDao.addNewCategory(category);
	}

	@Override
	public String updateCategory(Category category) {
		return categoryDao.updateCategory(category);
	}

	@Override
	public Category fetchById(int categoryId) {

		return categoryDao.fetchById(categoryId);
	}

	@Override
	public List<Category> fetchAllCategories() {

		return categoryDao.fetchAllCategories();
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		return categoryDao.deleteCategory(categoryId);

	}

}
