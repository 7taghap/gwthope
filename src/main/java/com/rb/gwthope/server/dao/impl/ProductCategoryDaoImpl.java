package com.rb.gwthope.server.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.rb.gwthope.server.dao.ProductCategoryDao;
import com.rb.gwthope.shared.dto.ProductCategory;

public class ProductCategoryDaoImpl extends AbstractJpaDao<Integer, ProductCategory> 
implements ProductCategoryDao{

	static Logger logger = Logger.getLogger(ProductCategoryDaoImpl.class);

	public ProductCategoryDaoImpl() {
		setClazz(ProductCategory.class);
	}
	@Override
	public ProductCategory findById(int id) {
		// TODO Auto-generated method stub
		return findOne(id);
	}

	@Override
	public List<ProductCategory> getProductCategories() {
		return findAll();
	}

	@Override
	public ProductCategory saveProductCategory(ProductCategory category) {
		if (category.getProductCategoryId() > 0) {
			update(category);
		}
		else {
			save(category);
		}
		return category;
	}

	@Override
	public boolean deleteProductCategory(ProductCategory category) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
