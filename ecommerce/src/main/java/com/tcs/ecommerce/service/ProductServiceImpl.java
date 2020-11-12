package com.tcs.ecommerce.service;

import java.util.Optional;

import com.tcs.ecommerce.dao.ProductDAOImpl;
import com.tcs.ecommerce.model.Product;

public class ProductServiceImpl implements ProductService {

	private static ProductServiceImpl productServiceImpl;
	
	public static synchronized ProductService getInstance() {
		if(productServiceImpl == null)
			productServiceImpl = new ProductServiceImpl();
		return productServiceImpl;
	}
	
	private ProductServiceImpl() {}
	
	@Override
	public String createProduct(Product product) {
		String result = ProductDAOImpl.getInstance().createProduct(product);
		return result;
	}

	@Override
	public Optional<Product> getProductById(int id) {
		Optional<Product> optional = ProductDAOImpl.getInstance().getProductById(id);
		return optional;
	}

}
