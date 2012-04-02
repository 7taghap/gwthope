package com.rb.gwthope.server.dao;

import java.util.List;

import com.rb.gwthope.shared.dto.ProductCategory;

public interface ProductCategoryDao {
	
	public ProductCategory findById(int id);
	public List<ProductCategory> getProductCategories();
	public ProductCategory saveProductCategory(ProductCategory category);
	public boolean deleteProductCategory (ProductCategory category);

}
