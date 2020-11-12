package com.tcs.ecommerce;

import java.util.Optional;

import com.tcs.ecommerce.dao.ProductDAO;
import com.tcs.ecommerce.dao.ProductDAOImpl;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.service.ProductService;
import com.tcs.ecommerce.service.ProductServiceImpl;

public class Main {
	public static void main(String[] args) {
		Product product = new Product(1, "laptop", "i5 10th gen", 123.0f, "laptop");
		ProductService productService = ProductServiceImpl.getInstance();
		String result = productService.createProduct(product);
		if("success".equals(result))
			System.out.println("record added successfully");
		else
			System.out.println("error adding record");
		
		Optional<Product> optional = productService.getProductById(1);
		if(optional.isPresent())
			System.out.println(optional.get());
		else
			System.out.println("issue");
	}
}
