package com.crud.spring_core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.spring_core.mapper.CategoryMapper;
import com.crud.spring_core.model.Category;
import com.crud.spring_core.queries.DBquries;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addNewCategory(Category category) {
		int result = jdbcTemplate.update(DBquries.ADD_NEW_CATEGORY, category.getCategoryId(),
				category.getCategoryName().toUpperCase());
		if (result != 0) {
			return "====== New Category Added Succesfully =====CATEGORY ID :: " + category.getCategoryId();
		}
		return "===== Category Not Added =====";
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String updateCategory(Category category) {
		int result = jdbcTemplate.update(DBquries.UPDATE_CATEGORY, category.getCategoryName().toUpperCase(),
				category.getCategoryId());
		if (result != 0) {
			return "=== Update Category Succesfully ===";
		}
		return "=== Category Not Updated ===";
	}

	@Override
	public Category fetchById(int categoryId) {
		Category category = null;
		try {
			CategoryMapper rowMapper = new CategoryMapper();
			category = jdbcTemplate.queryForObject(DBquries.FETCH_CATEGORY_BY_ID, rowMapper, categoryId);
		} catch (Exception e) {
			return null;
		}
		return category;

	}

	@Override
	public List<Category> fetchAllCategories() {

		CategoryMapper rowMapper = new CategoryMapper();
		return jdbcTemplate.query(DBquries.FETCH_ALL_CATEGORIES, rowMapper);
	}

	@Override
	public boolean deleteCategory(int categoryId) {
		int result=jdbcTemplate.update(DBquries.DELETE_CATEGORY, categoryId);
		if(result!=0) {
			return true;
		}else {
			return false;
		}
	}

}