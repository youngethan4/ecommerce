package com.tcs.ecommerce.dao;

import java.util.List;
import java.util.Optional;

import com.tcs.ecommerce.model.Product;

public class ProductDAOImpl implements ProductDAO {
	
	private static ProductDAOImpl productDAOImpl;
	
	public static synchronized ProductDAO getInstance() {
		if(productDAOImpl == null)
			productDAOImpl = new ProductDAOImpl();
		return productDAOImpl;
	}
	
	private ProductDAOImpl() {}

	@Override
	public String createProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> getProductById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<List<Product>> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Product> updateProduct(int id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
