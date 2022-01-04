package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.example.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	@Query("from Product where name=:pName")
	List<Product> getProductDetailsByName(@Param("pName") String name);

	@Query("from Product where price>=:prc")
	List<Product> getProductDetailsByPrice(@Param("prc") double price);

}
