package com.crud.spring_core.service;

import java.util.List;

import com.crud.spring_core.model.Brand;

public interface BrandService {

	String addNewBrand(Brand brand);

	String updateBrand(Brand brand);

	Brand fetchById(int brandId);

	List<Brand> fetchAllBrands();

	void deteteBrand(int brandId);
}
