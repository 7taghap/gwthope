package com.rb.gwthope.server;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.inject.Inject;
import com.rb.gwthope.server.dao.UnitConversionDao;
import com.rb.gwthope.server.dao.UserDao;
import com.rb.gwthope.shared.dto.Product;
import com.rb.gwthope.shared.dto.ProductCategory;
import com.rb.gwthope.shared.dto.UnitConversion;
import com.rb.gwthope.shared.dto.User;
import com.rb.gwthope.shared.services.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	private static final Logger logger =Logger.getLogger(ProductServiceImpl.class);
	
	@Autowired
	UnitConversionDao unitConversionDao;
	
	@Autowired
	UserDao userDao;

	@Override
	public ArrayList<UnitConversion> getDefaultUnits() {
		return (ArrayList<UnitConversion> )unitConversionDao.getAllUnitConversion();
		
	}

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getProduct(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductCategory> getCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
