package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.entity.Product;
import com.example.exception.ProductNotFoundException;
import com.example.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public List<Product> getProductDetails() {
		return productRepo.findAll();

	}

	public Product insert(Product product) {

		return productRepo.save(product);

	}

	public Optional<Product> getProducteDetailsById(int Id)  {

		Optional<Product> product = productRepo.findById(Id);
		if (!product.isPresent()) {
			throw new ProductNotFoundException();
		}
		return product;
	}

	public Product updateProduct(Product product, int Id) {
		return productRepo.save(product);

	}

	public void deleteProduct(int Id) {
		productRepo.deleteById(Id);

	}

	public List<Product> getProductDetailsByName(String name) {
		return productRepo.getProductDetailsByName(name);

	}

	public List<Product> getProductDetailsByPrice(double price) {
		return productRepo.getProductDetailsByPrice(price);

	}
}
