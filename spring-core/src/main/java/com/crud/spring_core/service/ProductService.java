package com.crud.spring_core.service;

import java.util.List;

import com.crud.spring_core.model.Product;

public interface ProductService {

	String addNewProduct(Product product);

	String updateProduct(Product product);

	Product fetchById(int productId);

	List<Product> fetchAllProducts();

	List<Product> fetchByPriceRange(double minPrice, double maxPrice);

	List<Product> fetchByBrandName(String brandName);

	List<Product> fetchByCategoryName(String categoryName);
	
	boolean deleteProduct(int productId);
}
