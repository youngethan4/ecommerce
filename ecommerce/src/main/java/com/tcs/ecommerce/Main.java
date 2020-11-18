package com.tcs.ecommerce;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tcs.ecommerce.config.DBConfig;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.service.ProductService;

public class Main {
	public static void main(String[] args) {
		Product product = new Product(2, "laptop2", "i7 10th gen", 158.0f, "laptop");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
		ProductService productService = context.getBean(ProductService.class);
		System.out.println(productService);
//		String result = productService.createProduct(product);
//		if("success".equals(result))
//			System.out.println("record added successfully");
//		else
//			System.out.println("error adding record");
//		
//		Optional<Product> optional = productService.getProductById(1);
//		if(optional.isPresent())
//			System.out.println(optional.get());
//		else
//			System.out.println("issue");
		
		Optional<List<Product>> optional2 = productService.getProductsGreaterThan(160.0f);
		if(optional2.isPresent()) {
			List<Product> products = optional2.get();
			products.forEach(p -> {
				System.out.println(p);
			});
		} else {
			System.out.println("problem");
		}
		
	}
}
