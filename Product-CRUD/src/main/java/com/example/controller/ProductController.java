package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Product;
import com.example.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/getallproduct")
	public ResponseEntity<List<Product>> getProductDetails() {
		List<Product> allProduct = productService.getProductDetails();

		return new ResponseEntity<List<Product>>(allProduct, HttpStatus.OK);
	}

	@GetMapping("/product/{Id}")
	public ResponseEntity<Optional<Product>> getProductDetailsById(@PathVariable int Id) {
		Optional<Product> productRetrieved = productService.getProducteDetailsById(Id);
		return new ResponseEntity<Optional<Product>>(productRetrieved, HttpStatus.OK);

	}

	@PostMapping("/insertproduct")
	public ResponseEntity<Product> insert(@RequestBody Product product) {
		Product productadd = productService.insert(product);
		return new ResponseEntity<Product>(productadd, HttpStatus.ACCEPTED);
	}

	@PutMapping("/update/{Id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int Id) {
		Product productupdate = productService.updateProduct(product, Id);
		return new ResponseEntity<Product>(productupdate, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int Id) {

		productService.deleteProduct(Id);
		return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
	}

	@GetMapping("/getByName/{name}")
	public ResponseEntity<List<Product>> getProductDetailsByName(@PathVariable String name) {

		List<Product> ByName = productService.getProductDetailsByName(name);
		return new ResponseEntity<List<Product>>(ByName, HttpStatus.OK);

	}

	@GetMapping("/getByPrice/{price}")
	public ResponseEntity<List<Product>> getProductDetailsByPrice(@PathVariable double price) {

		List<Product> ByPrice = productService.getProductDetailsByPrice(price);
		return new ResponseEntity<List<Product>>(ByPrice, HttpStatus.OK);
	}
	
	
}
