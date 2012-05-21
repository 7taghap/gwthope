package com.rb.gwthope.server;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.spring.annotation.SpringApplicationContext;

import com.rb.gwthope.server.dao.ProductCategoryDao;
import com.rb.gwthope.server.dao.impl.ProductCategoryDaoImpl;
import com.rb.gwthope.shared.dto.ProductCategory;

@JpaEntityManagerFactory(persistenceUnit="testPU", configFile="META-INF/persistence-test.xml")
@SpringApplicationContext({"classpath:spring-config.xml","classpath:test-config.xml"})
public class ProductCategoryDaoImplTest extends UnitilsTestNG{
	static Logger logger = Logger.getLogger(ProductCategoryDaoImplTest.class.getName());
	
	 @PersistenceContext
	 EntityManager entityManager;
	 
	 ProductCategoryDao productCategoryDao;
	 
	 @BeforeMethod
	 public void setUp() {
		 productCategoryDao  = new ProductCategoryDaoImpl();
		 JpaUnitils.injectEntityManagerInto(productCategoryDao);
	  }
	
	 @Test
	 public void findAll() {
		 List<ProductCategory> categories = productCategoryDao.getProductCategories();
//		 Assert.assertEquals(categories, null);
		 for (ProductCategory category : categories) {
			 System.out.println(category.toString());
			 logger.info(category);
		 }
	 }

}
