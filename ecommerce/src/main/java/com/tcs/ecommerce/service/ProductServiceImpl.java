package com.tcs.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.ecommerce.dao.ProductDAO;
import com.tcs.ecommerce.model.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDao;

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
		String result = productDao.createProduct(product);
		return result;
	}

	@Override
	public Optional<Product> getProductById(int id) {
		Optional<Product> optional = productDao.getProductById(id);
		return optional;
	}

}
