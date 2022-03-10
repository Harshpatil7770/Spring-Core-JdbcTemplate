package com.crud.spring_core.queries;

public class DBquries {

	public static final String ADD_NEW_BRAND = "insert into brands values(?,?)";

	public static final String UPDATE_BRAND = "update brands set brand_name=? where brand_id=?";

	public static final String FETCH_BRAND_BY_ID = "select * from brands where brand_id=?";

	public static final String FETCH_ALL_BRANDS = "select * from brands";

	public static final String DELETE_BRAND = "delete from brands where brand_id=?";

	public static final String ADD_NEW_CATEGORY = "insert into categories values(?,?)";

	public static final String UPDATE_CATEGORY = "update categories set category_name=? where category_id=?";

	public static final String FETCH_CATEGORY_BY_ID = "select * from categories where category_id=?";

	public static final String FETCH_ALL_CATEGORIES = "select * from categories";

	public static final String DELETE_CATEGORY = "delete from categories where category_id=?";

	public static final String ADD_NEW_PRODUCT = "insert into products values(?,?,?,?,?,?)";

	public static final String UPDATE_PRODUCT = "update products set product_name=?,price=?,description=?,"
			+ "brand_id=?,category_id=?" + " where product_id=?";

	public static final String FETCH_PRODUCT_BY_ID = "select p.product_id,p.product_name,p.price,"
			+ " p.description,b.brand_id,b.brand_name,c.category_id,c.category_name from products p "
			+ " inner join brands b on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id "
			+ " where p.product_id=?";

	public static final String FETCH_ALL_PRODUCTS = "select * from products p inner join brands b"
			+ " on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id";

	public static final String FILTER_PRODUCT_BY_PRICE_RANGE = "select * from products p inner join brands b "
			+ "on p.product_id=b.brand_id inner join categories c on "
			+ "p.category_id=c.category_id where p.price>=? and p.price<=?";
	
	public static final String FILTER_PRODUCT_BY_BRAND_NAME="select * from products p inner join brands b "
			+ " on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id where"
			+ " b.brand_name=?";
	
	public static final String FILTER_PRODUCT_BY_CATEGORY_NAME="select * from products p inner join brands b "
			+ " on p.brand_id=b.brand_id inner join categories c on p.category_id=c.category_id where"
			+ " c.category_name=?";

	public static final String DELETE_PRODUCT="delete from products where product_id=?";
}
