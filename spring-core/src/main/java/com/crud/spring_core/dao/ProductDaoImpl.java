package com.crud.spring_core.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.spring_core.mapper.ProductMapper;
import com.crud.spring_core.model.Brand;
import com.crud.spring_core.model.Category;
import com.crud.spring_core.model.Product;
import com.crud.spring_core.queries.DBquries;
import com.mysql.cj.protocol.ResultsetRow;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public String addNewProduct(Product product) {

		int result = jdbcTemplate.update(DBquries.ADD_NEW_PRODUCT, product.getProductId(), product.getProductName(),
				product.getPrice(), product.getDescription(), product.getBrand().getBrandId(),
				product.getCategory().getCategoryId());
		if (result != 0) {
			return "====== New Product Added Succesfully ======";
		} else {
			return "===== Not able to add New Product =====";
		}
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String updateProduct(Product product) {
		int result = jdbcTemplate.update(DBquries.UPDATE_PRODUCT, product.getProductName(), product.getPrice(),
				product.getDescription(), product.getBrand().getBrandId(), product.getCategory().getCategoryId(),
				product.getProductId());

		if (result != 0) {
			return "===== Updated Product Records Succesfully ======";
		}
		return "==== Not Able to update product records =====";
	}

	@Override
	public Product fetchById(int productId) {
		Product product;
		try {
			ProductMapper rowMapper = new ProductMapper();
			product = jdbcTemplate.queryForObject(DBquries.FETCH_PRODUCT_BY_ID, rowMapper, productId);
		} catch (Exception e) {
			return null;
		}
		return product;

	}

	@Override
	public List<Product> fetchAllProducts() {
		ProductMapper rowMapper = new ProductMapper();
		return jdbcTemplate.query(DBquries.FETCH_ALL_PRODUCTS, rowMapper);
	}

	@Override
	public List<Product> fetchByPriceRange(double minPrice, double maxPrice) {
		List<Product> lists = new ArrayList<Product>();
		return jdbcTemplate.query(DBquries.FILTER_PRODUCT_BY_PRICE_RANGE, (ResultSet rs) -> {
			while (rs.next()) {
				Product product = new Product();
				Brand brand = new Brand();
				Category category = new Category();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDescription(rs.getString(4));
				brand.setBrandId(rs.getInt(5));
				brand.setBrandName(rs.getString(6));
				category.setCategoryId(rs.getInt(7));
				category.setCategoryName(rs.getString(8));
				product.setBrand(brand);
				product.setCategory(category);
				lists.add(product);
			}
			return lists;
		}, minPrice, maxPrice);

	}

	@Override
	public List<Product> fetchByBrandName(String brandName) {
		List<Product> lists = new ArrayList<Product>();
		return jdbcTemplate.query(DBquries.FILTER_PRODUCT_BY_BRAND_NAME, (ResultSet rs) -> {
			while (rs.next()) {
				Product product = new Product();
				Brand brand = new Brand();
				Category category = new Category();
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDescription(rs.getString(4));
				brand.setBrandId(rs.getInt(5));
				brand.setBrandName(rs.getString(6));
				category.setCategoryId(rs.getInt(7));
				category.setCategoryName(rs.getString(8));

				product.setBrand(brand);
				product.setCategory(category);
				lists.add(product);
			}
			return lists;
		}, brandName);

	}

	@Override
	public List<Product> fetchByCategoryName(String categoryName) {
		List<Product> lists = new ArrayList<Product>();
		return jdbcTemplate.query(DBquries.FILTER_PRODUCT_BY_CATEGORY_NAME, (ResultSet rs) -> {
			while (rs.next()) {
				Product product = new Product();
				Brand brand = new Brand();
				Category category = new Category();

				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setDescription(rs.getString(4));
				brand.setBrandId(rs.getInt(5));
				brand.setBrandName(rs.getString(6));
				category.setCategoryId(rs.getInt(7));
				category.setCategoryName(rs.getString(8));

				product.setBrand(brand);
				product.setCategory(category);
				lists.add(product);
			}
			return lists;
		}, categoryName);

	}

	@Override
	public boolean deleteProduct(int productId) {
	
		int result=jdbcTemplate.update(DBquries.DELETE_PRODUCT,productId);
		if(result!=0) {
			return true;
		}
		return false;
	}

}
