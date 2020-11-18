package com.tcs.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tcs.ecommerce.model.Product;
import com.tcs.ecommerce.utils.DBUtils;

//@Repository 
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private DBUtils dbUtils;
	
//	private static ProductDAOImpl productDAOImpl;
//	
//	public static synchronized ProductDAO getInstance() {
//		if(productDAOImpl == null)
//			productDAOImpl = new ProductDAOImpl();
//		return productDAOImpl;
//	}
//	
//	private ProductDAOImpl() {}

	@Override
	public String createProduct(Product product) {
		Connection connection = dbUtils.getConnection();
		int result = 0;
		String insertProduct = "insert into product (productId, productName, description, "
				+ "category, price) values(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertProduct);
			preparedStatement.setInt(1, product.getProductId());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getDescription());
			preparedStatement.setString(4, product.getCategory());
			preparedStatement.setFloat(5, product.getPrice());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
				return "success";
			} else
				return "fail";
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return "fail";
		} finally {
			dbUtils.closeConnection(connection);
		}
	}

	@Override
	public Optional<Product> getProductById(int id) {
		Connection connection = dbUtils.getConnection();
		Product product = null;
		ResultSet resultSet = null;
		String query = "select * from product where productId=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				product = new Product();
				product.setProductId(resultSet.getInt("productId"));
				product.setProductName(resultSet.getString("productName"));
				product.setDescription(resultSet.getString("description"));
				product.setCategory(resultSet.getString("category"));
				product.setPrice(resultSet.getFloat("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Optional.empty();
		} finally {
			dbUtils.closeConnection(connection);
		}
		return Optional.of(product);
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
