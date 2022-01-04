package com.example.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.Product;
import com.example.repo.ProductRepo;
import com.example.service.ProductService;

@SpringBootTest
class ProductServiceTest {
	
	@Mock
	ProductRepo productRepo;
	
	@InjectMocks
	ProductService productService;
	

	@Test
	public void test() {
		List<Product> allProduct= new LinkedList<>();
		allProduct.add(new Product(1,"Sony","10",60000));
		allProduct.add(new Product(2,"Hp","10",70000));
		when(productRepo.findAll()).thenReturn(allProduct);
		assertEquals(allProduct, productService.getProductDetails());
	}
       @Test
       public void test_insert() {
    	   Product product = new Product(101,"Hp","5",50000);
    	   when(productRepo.save(product)).thenReturn(product);
    	   assertEquals(product, productService.insert(product));
       }
       @Test
       public void test_byId() {
    	   Optional<Product> product = Optional.of(new Product(104,"Sony","10",60000));
    	   when(productRepo.findById(104)).thenReturn(product);
    	   assertEquals(product, productService.getProducteDetailsById(104));
       }
       
       @Test
       public void test_update() {
    	   Product product = new Product(101,"Hp","5",50000);
    	   when(productRepo.save(product)).thenReturn(product);
    	   assertEquals(product, productService.updateProduct(product, 101));
       }
       
       @Test
       public void test_Delete()
       {
    	   int Id = 101;
    	   
    	   productService.deleteProduct(101);
    	   verify(productRepo,times(1)).deleteById(101);
       }
       
       @Test
       public void test_byName() {
    	   List<Product> product = new LinkedList <Product>();    
           product.add(new Product(101,"Hp","5",50000));  
           when(productRepo.getProductDetailsByName("Hp")).thenReturn(product);
           assertEquals(product, productService.getProductDetailsByName("Hp"));
    	   
       }
       
       @Test
       public void test_byPrice() {
    	   List<Product> product = new LinkedList<Product>();
    	   product.add(new Product(101,"Hp","5",50000));
    	   when(productRepo.getProductDetailsByPrice(50000)).thenReturn(product);
    	   assertEquals(product, productService.getProductDetailsByPrice(50000));
    	   
       }
}
