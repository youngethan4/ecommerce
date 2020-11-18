package com.tcs.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.ecommerce.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(String category);
	List<Product> findByPriceGreaterThan(float price);
	List<Product> findByCategoryAndPriceLessThan(String category, float price);
	List<Product> findByProductNameLike(String productName);
}
