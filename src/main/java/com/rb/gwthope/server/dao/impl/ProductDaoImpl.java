package com.rb.gwthope.server.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rb.gwthope.server.constants.MyNamedQueries;
import com.rb.gwthope.server.dao.ProductDao;
import com.rb.gwthope.shared.dto.Product;
import com.rb.gwthope.shared.exceptions.ProductCategoryException;
import com.rb.gwthope.shared.exceptions.ProductNotSaveException;

@Repository
public class ProductDaoImpl extends AbstractJpaDao<Integer, Product> implements ProductDao {

	public ProductDaoImpl() {
		setClazz(Product.class);
	}
	
	@Override
	public Product findById(int id) {
		return findOne(id);
	}

	@Override
	public Product saveProduct(Product product) throws ProductNotSaveException{
		try{
			if(product.getProductId() > 0) {
				update(product);
			}
			else {
				save(product);
			}
		}catch(Exception e) {
			throw new ProductNotSaveException("failed to save product");
		}

		return product;
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> findByCategory(String category) {
		@SuppressWarnings("unchecked")
		List<Product> products = entityManager.createNamedQuery(MyNamedQueries.PRODUCT_FIND_BY_CATEGORY)
				.setParameter(MyNamedQueries.SEARCH_NAME, category).getResultList();
		return products;
	}

	@Override
	public List<Product> findByName(String name) {
		@SuppressWarnings("unchecked")
		List<Product> products = entityManager.createNamedQuery(MyNamedQueries.PRODUCT_FIND_BY_NAME)
				.setParameter(MyNamedQueries.SEARCH_NAME, name).getResultList();
		return products;
	}

}
