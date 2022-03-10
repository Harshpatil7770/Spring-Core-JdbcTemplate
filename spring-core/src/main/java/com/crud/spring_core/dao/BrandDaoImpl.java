package com.crud.spring_core.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.crud.spring_core.mapper.BrandMapper;
import com.crud.spring_core.model.Brand;
import com.crud.spring_core.queries.DBquries;

@Repository
public class BrandDaoImpl implements BrandDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String addNewBrand(Brand brand) {

		int result = jdbcTemplate.update(DBquries.ADD_NEW_BRAND, brand.getBrandId(), brand.getBrandName());
		if (result != 0) {
			return "========== New Brand Added Succesfully =========";
		}
		return "==== Brand Not Added =====";
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String updateBrand(Brand brand) {

		int result = jdbcTemplate.update(DBquries.UPDATE_BRAND, brand.getBrandName(), brand.getBrandId());
		if (result != 0) {
			return "========== Update brand Succesfully =========";
		}
		return "===== Brand Not updated =====";
	}

	public Brand fetchById(int brandId) {
		Brand brand = null;
		try {
			BrandMapper rowMapper = new BrandMapper();
			brand = jdbcTemplate.queryForObject(DBquries.FETCH_BRAND_BY_ID, rowMapper, brandId);
		} catch (Exception e) {
			return null;
		}
		return brand;

	}

	public List<Brand> fetchAllBrands() {
		String sql = "select * from brands";
		BrandMapper rowMapper = new BrandMapper();
		return jdbcTemplate.query(DBquries.FETCH_ALL_BRANDS, rowMapper);
	}

	@Override
	public boolean deteteBrand(int brandId) {
		int result = jdbcTemplate.update(DBquries.DELETE_BRAND, brandId);
		if (result != 0) {
			return true;
		}
		return false;
	}

}
