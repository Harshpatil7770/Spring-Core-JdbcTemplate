package com.crud.spring_core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.crud.spring_core.model.Brand;
import com.crud.spring_core.model.Category;
import com.crud.spring_core.model.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		Brand brand = new Brand();
		Category category = new Category();
		product.setProductId(rs.getInt(1));
		product.setProductName(rs.getString(2));
		product.setPrice(rs.getDouble(3));
		product.setDescription(rs.getString(4));
		brand.setBrandId(rs.getInt(5));
		brand.setBrandName(rs.getString(6));
		product.setBrand(brand);
		category.setCategoryId(rs.getInt(7));
		category.setCategoryName(rs.getString(8));
		product.setCategory(category);

		return product;
	}

}
