package com.rb.gwthope.server.dao;

import java.util.List;

import com.rb.gwthope.shared.dto.Product;
import com.rb.gwthope.shared.exceptions.ProductNotSaveException;

public interface ProductDao {

	Product findById(int id);
	Product saveProduct(Product product) throws ProductNotSaveException;
	boolean deleteProduct(Product product);
	List<Product> findByCategory(String category);
	List<Product> findByName(String name);
}
