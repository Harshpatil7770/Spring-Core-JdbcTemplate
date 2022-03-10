package com.crud.spring_core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.spring_core.dao.BrandDao;
import com.crud.spring_core.model.Brand;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	BrandDao brandDao;

	public String addNewBrand(Brand brand) {
		return brandDao.addNewBrand(brand);
	}

	public String updateBrand(Brand brand) {
		return brandDao.updateBrand(brand);
	}

	public Brand fetchById(int brandId) {
		return brandDao.fetchById(brandId);
	}

	public List<Brand> fetchAllBrands() {
		return brandDao.fetchAllBrands();
	}

	@Override
	public void deteteBrand(int brandId) {
		brandDao.deteteBrand(brandId);
	}

}
