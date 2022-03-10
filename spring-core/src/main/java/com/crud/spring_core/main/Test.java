package com.crud.spring_core.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.crud.spring_core.dao.BrandDao;
import com.crud.spring_core.dao.CategoryDao;
import com.crud.spring_core.dao.ProductDao;
import com.crud.spring_core.model.Brand;
import com.crud.spring_core.model.Category;
import com.crud.spring_core.model.Product;
import com.crud.spring_core.validation.InputValidation;

public class Test {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = 1;
		do {

			ApplicationContext ac = new ClassPathXmlApplicationContext("com/crud/spring_core/main/config.xml");

			BrandDao brandDao = (BrandDao) ac.getBean("brandDaoImpl");
			CategoryDao categoryDao = (CategoryDao) ac.getBean("categoryDaoImpl");
			ProductDao productDao = (ProductDao) ac.getBean("productDaoImpl");
			System.out.println("----------------------------------------------------");
			System.out.println("|        1) Add New Brand                          | ");
			System.out.println("|        2) Update Existing Brand                  |");
			System.out.println("|        3) Fetch Brand By Id                      |");
			System.out.println("|        4) Fetch All Brands                       |");
			System.out.println("|        5) Delete Brand                           |");
			System.out.println("|        6) Add New Category                       |");
			System.out.println("|        7) Update Existing Category               |");
			System.out.println("|        8) Fetch Category By Id                   |");
			System.out.println("|        9) Fetch All Category                     |");
			System.out.println("|        10) Delete Category                       |");
			System.out.println("|        11) Add New Product                       |");
			System.out.println("|        12) Update Product                        |");
			System.out.println("|        13) Fetch Product By ID                   |");
			System.out.println("|        14) Fetch All Products                    |");
			System.out.println("|        15) Fetch Products In Betweeen            | "
					+ "\n|              Price Range                         |");
			System.out.println("|        16) Fetch Products by Brand               | "
					+ "\n|              Name                                |");
			System.out.println("|        17) Fetch Products by Category            | "
					+ "\n|              Name                                |");
			System.out.println("|        18) Delete Product                        |");
			System.out.println("----------------------------------------------------");
			System.out.println("\nEnter your choice no                    ");
			System.out.println("-------------------------------------------");
			Brand brand = new Brand();
			Category category = new Category();
			Product product = new Product();

			int num = InputValidation.inputIntegerValidation();
			switch (num) {

			case 1:
				System.out.println("------------------------------------------");
				System.out.println("You have selected option 1) Add New Brand ");
				System.out.println("------------------------------------------");
				System.out.println("\nEnter the brand Name :: ");
				String brandName = InputValidation.inputStringValidation();
				brand.setBrandName(brandName);
				brandDao.addNewBrand(brand);
				System.out.println("New Brand Added Succesfully :: Brand Name : " + brand.getBrandName().toUpperCase());
				break;

			case 2:
				System.out.println("-------------------------------------------------");
				System.out.println("You have selected option 2) Update Existing Brand");
				System.out.println("-------------------------------------------------");
				System.out.println("\nEnter Existing Brand Id ::");
				int existingBrandId = InputValidation.inputIntegerValidation();
				brand.setBrandId(existingBrandId);
				System.out.println("\nEnter the new Brand Name ::");
				String newBrandName = InputValidation.inputStringValidation();
				brand.setBrandName(newBrandName);
				brandDao.updateBrand(brand);
				System.out.println("\nBrand Updated Succesfully :: Brand Name : " + brand.getBrandName().toUpperCase());
				break;

			case 3:
				System.out.println("---------------------------------------------");
				System.out.println("You have selected option 3) Fetch Brand By Id");
				System.out.println("---------------------------------------------");
				System.out.println("\nEnter Brand Id ::");
				int BrandId = InputValidation.inputIntegerValidation();
				System.out.println(brandDao.fetchById(BrandId));
				break;

			case 4:
				System.out.println("--------------------------------------------");
				System.out.println("You have selected option 4) Fetch All Brands");
				System.out.println("--------------------------------------====--");
				brandDao.fetchAllBrands().forEach(System.out::println);
				break;

			case 5:
				System.out.println("----------------------------------------");
				System.out.println("You have selected option 5) Delete Brand");
				System.out.println("----------------------------------------");
				System.out.println("\nEnter Brand Id ::");
				int brandId = InputValidation.inputIntegerValidation();
				boolean result = brandDao.deteteBrand(brandId);
				if (result == true) {
					System.out.println("Brand Deleted Succesfully !");
				} else {
					System.out.println("Entered brand id not present in db !");
				}
				break;

			case 6:
				System.out.println("--------------------------------------------");
				System.out.println("You have selected option 6) Add new Category");
				System.out.println("--------------------------------------------");
				System.out.println("\nEnter Category Name ::");
				String categoryName = InputValidation.inputStringValidation();
				category.setCategoryName(categoryName.toUpperCase());
				categoryDao.addNewCategory(category);
				System.out.println("New Category Added Succesfully :: category Name : "
						+ category.getCategoryName().toUpperCase());
				break;

			case 7:
				System.out.println("--------------------------------------------");
				System.out.println("You have selected option 7) Update Category");
				System.out.println("--------------------------------------------");
				System.out.println("\nEnter Existing Category Id ::");
				int categoryId = InputValidation.inputIntegerValidation();
				category.setCategoryId(categoryId);
				System.out.println("\nEnter Category Name ::");
				String cat_name = InputValidation.inputStringValidation();
				category.setCategoryName(cat_name.toUpperCase());
				categoryDao.updateCategory(category);
				System.out.println(
						"Category Updated Succesfully :: category Name : " + category.getCategoryName().toUpperCase());
				break;

			case 8:
				System.out.println("---------------------------------------------");
				System.out.println("You have selected option 8) Fetch By Category");
				System.out.println("---------------------------------------------");
				System.out.println("\nEnter Category Id ::");
				int category_id = InputValidation.inputIntegerValidation();
				System.out.println(categoryDao.fetchById(category_id));
				break;

			case 9:
				System.out.println("------------------------------------------------");
				System.out.println("You have selected option 9) Fetch All Categories");
				System.out.println("------------------------------------------------");
				categoryDao.fetchAllCategories().forEach(System.out::println);
				break;

			case 10:
				System.out.println("--------------------------------------------");
				System.out.println("You have selected option 10) Delete Category");
				System.out.println("--------------------------------------------");
				System.out.println("\nEnter Category Id:: ");
				int cat_id = InputValidation.inputIntegerValidation();
				boolean res = categoryDao.deleteCategory(cat_id);
				if (res == true) {
					System.out.println("Delete Category Succesfully !");
				} else {
					System.out.println("Entered category id not present in db !");
				}
				break;

			case 11:
				System.out.println("--------------------------------------------");
				System.out.println("You have selected option 11) Add New Product");
				System.out.println("--------------------------------------------");
				System.out.println("\nEnter Product Name ::");
				String productName = InputValidation.inputStringValidation();
				product.setProductName(productName);
				System.out.println("\nEnter Product Price ::");
				double productPrice = InputValidation.inputIntegerValidation();
				product.setPrice(productPrice);
				System.out.println("\nEnter Product Description ::");
				String productDesc = sc.nextLine();
				System.out.println("Thank you! " + productDesc);
				product.setDescription(productDesc);
				System.out.println("\nEnter Brand Id::");
				int brand_id = InputValidation.inputIntegerValidation();
				brand.setBrandId(brand_id);
				product.setBrand(brand);
				System.out.println("\nEnter Category Id::");
				int cate_id = InputValidation.inputIntegerValidation();
				category.setCategoryId(cate_id);
				product.setCategory(category);
				productDao.addNewProduct(product);
				System.out.println(
						"New Product Added Succesfully :: Product Name : " + product.getProductName().toUpperCase());
				break;
			case 12:
				System.out.println("-------------------------------------------");
				System.out.println("You have selected option 12) Update Product");
				System.out.println("-------------------------------------------");
				System.out.println("\nEnter Existing Product Id ::");
				int existingProductId = InputValidation.inputIntegerValidation();
				product.setProductId(existingProductId);
				System.out.println("\nEnter Product Name ::");
				String product_name = InputValidation.inputStringValidation();
				product.setProductName(product_name);
				System.out.println("\nEnter Product Price ::");
				double product_price = InputValidation.inputIntegerValidation();
				product.setPrice(product_price);
				System.out.println("\nEnter Product description ::");
				String product_desc = sc.nextLine();
				System.out.println("Thank you! " + product_desc);
				product.setDescription(product_desc);
				System.out.println("\nEnter Brand Id ::");
				int brandid = InputValidation.inputIntegerValidation();
				brand.setBrandId(brandid);
				product.setBrand(brand);
				System.out.println("\nEnter Category Id ::");
				int categoryid = sc.nextInt();
				category.setCategoryId(categoryid);
				product.setCategory(category);
				productDao.updateProduct(product);
				System.out.println(
						"Update Product Succesfully :: Product Name : " + product.getProductName().toUpperCase());
				break;

			case 13:
				System.out.println("-----------------------------------------------");
				System.out.println("You have selected option 13)Fetch Product By ID");
				System.out.println("-----------------------------------------------");
				System.out.println("\nEnter Product ID ::");
				int prod_id = InputValidation.inputIntegerValidation();
				System.out.println(productDao.fetchById(prod_id));
				break;

			case 14:
				System.out.println("----------------------------------------------");
				System.out.println("You have selected option 14)Fetch All Products");
				System.out.println("----------------------------------------------");
				productDao.fetchAllProducts().forEach(System.out::println);
				break;
		
			case 15:
				System.out.println("---------------------------------------------------------------------");
				System.out.println("You have selected option 15)Fetch All Products In between Price Range");
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Enter Min Price :: ");
				double minPrice = InputValidation.inputIntegerValidation();
				product.setPrice(minPrice);
				System.out.println("Enter Max Price :: ");
				double maxPrice = InputValidation.inputIntegerValidation();
				product.setPrice(maxPrice);
				productDao.fetchByPriceRange(minPrice, maxPrice).forEach(System.out::println);
				break;
	
			case 16:
				System.out.println("------------------------------------------------------------");
				System.out.println("You have selected option 16)Fetch All Products by brand Name");
				System.out.println("------------------------------------------------------------");
				System.out.println("Enter Brand Name :: ");
				String brand_name = InputValidation.inputStringValidation();
				productDao.fetchByBrandName(brand_name).forEach(System.out::println);
				break;
		
			case 17:
				System.out.println("---------------------------------------------------------------");
				System.out.println("You have selected option 17)Fetch All Products by Category Name");
				System.out.println("---------------------------------------------------------------");
				System.out.println("Enter Category Name :: ");
				String category_name = InputValidation.inputStringValidation();
				productDao.fetchByCategoryName(category_name).forEach(System.out::println);
				break;
				
			case 18:
				System.out.println("---------------------------------------------------------------");
				System.out.println("You have selected option 18) Delete Product");
				System.out.println("---------------------------------------------------------------");
				System.out.println("Enter Exisitng product id :: ");
				int product_id=sc.nextInt();
				boolean flag=productDao.deleteProduct(product_id);
				if(flag==true) {
					System.out.println("=== Deleted Product Succesfully! ===");
				}else {
					System.out.println("=== Entered Product Id not present in db ===");
				}
				break;
			default:
				System.out.println("----------------------------------------------------------");
				System.out.println(">>>>------- Please enter available choice number ------<<<");
				System.out.println("----------------------------------------------------------");

			}
			System.out.println("-------------------------------------");
			System.out.println("\nDo you want to continue? 1)yes 2)no");
			n = InputValidation.inputIntegerValidation();

		} while (n == 1);

	}
}
