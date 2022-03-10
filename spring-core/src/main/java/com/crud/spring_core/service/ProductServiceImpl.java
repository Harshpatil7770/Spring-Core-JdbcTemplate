package com.crud.spring_core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.spring_core.dao.ProductDao;
import com.crud.spring_core.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public String addNewProduct(Product product) {
		return productDao.addNewProduct(product);
	}

	@Override
	public String updateProduct(Product product) {
		return productDao.updateProduct(product);
	}

	@Override
	public Product fetchById(int productId) {
		return productDao.fetchById(productId);
	}

	@Override
	public List<Product> fetchAllProducts() {
		return productDao.fetchAllProducts();
	}

	@Override
	public List<Product> fetchByPriceRange(double minPrice, double maxPrice) {
		return productDao.fetchByPriceRange(minPrice, maxPrice);
	}

	@Override
	public List<Product> fetchByBrandName(String brandName) {
		return productDao.fetchByBrandName(brandName);
	}

	@Override
	public List<Product> fetchByCategoryName(String categoryName) {
		return productDao.fetchByCategoryName(categoryName);
	}

	@Override
	public boolean deleteProduct(int productId) {
		return productDao.deleteProduct(productId);
	}

}
