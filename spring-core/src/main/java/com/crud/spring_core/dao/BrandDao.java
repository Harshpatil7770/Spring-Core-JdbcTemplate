package com.crud.spring_core.dao;

import java.util.List;

import com.crud.spring_core.model.Brand;

public interface BrandDao {

	String addNewBrand(Brand brand);

	String updateBrand(Brand brand);

	Brand fetchById(int brandId);

	List<Brand> fetchAllBrands();
	
	boolean deteteBrand(int brandId);
	
	
}
