package com.crud.spring_core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.crud.spring_core.model.Brand;

public class BrandMapper implements RowMapper<Brand> {

	public Brand mapRow(ResultSet rs, int rowNum) throws SQLException {
		Brand brand = new Brand();
		brand.setBrandId(rs.getInt(1));
		brand.setBrandName(rs.getString(2));
		return brand;
	}

}
