package com.tcs.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ecommerce.dao.ProductDAO;
import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

//	private static ProductServiceImpl productServiceImpl;
//	
//	public static synchronized ProductService getInstance() {
//		if(productServiceImpl == null)
//			productServiceImpl = new ProductServiceImpl();
//		return productServiceImpl;
//	}
//	
//	private ProductServiceImpl() {}
	
	@Override
	public String createProduct(Product product) {
		Product product2 = null;
		try {
			product2 = productRepository.save(product);
			return "success";
		} catch(Exception e) {
			e.printStackTrace();
			return "fail";
		}
	}

	@Override
	public Optional<Product> getProductById(int id) {
		Optional<Product> optional = null;
		try {
			optional = productRepository.findById(id);
			return optional;
		} catch(Exception e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public Optional<List<Product>> getProducts() {
		return Optional.ofNullable(productRepository.findAll());
	}

	@Override
	public Optional<List<Product>> getProductsByCategory(String category) {
		return Optional.ofNullable(productRepository.findByCategory(category));
	}

	@Override
	public Optional<List<Product>> getProductsGreaterThan(float price) {
		return Optional.ofNullable(productRepository.findByPriceGreaterThan(price));
	}

}
