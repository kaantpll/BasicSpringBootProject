package com.example.mybackendproject.SpringProject.dataAccess.abstracts;

import com.example.mybackendproject.SpringProject.entities.concrete.Product;

import com.example.mybackendproject.SpringProject.entities.dtos.ProductWithCategoryDto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductDao extends JpaRepository<Product,Integer>{
	
	Product getByProductName(String productName);
	Product getByProductNameAndCategory_CategoryId(String productName,int categoryId);
	List<Product> getByProductNameOrCategory_CategoryId(String productName,int categoryId);
	List<Product> getByCategoryIn(List<Integer> categories);
	
	List<Product> getByProductNameContains(String productName);
	
	List<Product> getByProductNameStartsWith(String productName);
	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCategory(String productName,int categoryId);
	@Query("Select new com.example.mybackendproject.SpringProject.entities.dtos.ProductWithCategoryDto"+ "(p.id, p.productName, c.categoryName) "+ "From Category c Inner Join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
}
