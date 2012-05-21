package com.rb.gwthope.server;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.gwthope.server.dao.ProductCategoryDao;
import com.rb.gwthope.server.dao.ProductDao;
import com.rb.gwthope.server.dao.UnitConversionDao;
import com.rb.gwthope.server.dao.UserDao;
import com.rb.gwthope.shared.dto.Product;
import com.rb.gwthope.shared.dto.ProductCategory;
import com.rb.gwthope.shared.dto.UnitConversion;
import com.rb.gwthope.shared.exceptions.ProductCategoryException;
import com.rb.gwthope.shared.exceptions.ProductNotSaveException;
import com.rb.gwthope.shared.services.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	private static final Logger logger =Logger.getLogger(ProductServiceImpl.class);
	
	@Autowired
	UnitConversionDao unitConversionDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ProductCategoryDao productCategoryDao;
	
	@Autowired
	ProductDao productDao;

	@Override
	public ArrayList<UnitConversion> getDefaultUnits() {
		return (ArrayList<UnitConversion> )unitConversionDao.getAllUnitConversion();
		
	}

	@Override
	public Product saveProduct(Product product) throws ProductNotSaveException {
		return productDao.saveProduct(product);
	}

	@Override
	public Product getProduct(int productId) {
		return productDao.findById(productId);
	}

	@Override
	public ArrayList<ProductCategory> getCategories(){
		// TODO Auto-generated method stub
		return (ArrayList<ProductCategory>) productCategoryDao.getProductCategories();
	}

}
