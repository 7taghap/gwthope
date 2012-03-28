package com.rb.gwthope.server;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.spring.annotation.SpringApplicationContext;

import com.rb.gwthope.server.constants.MyNamedQueries;
import com.rb.gwthope.server.dao.UnitConversionDao;
import com.rb.gwthope.server.dao.impl.UnitConversionDaoImpl;
import com.rb.gwthope.shared.dto.UnitConversion;

@JpaEntityManagerFactory(persistenceUnit="testPU", configFile="META-INF/persistence-test.xml")
@SpringApplicationContext({"classpath:spring-config.xml","classpath:test-config.xml"})
public class UnitConversionDaoImplTest extends UnitilsTestNG{
	private static Logger logger = Logger.getLogger(UnitConversionDaoImplTest.class.getName());
	UnitConversionDao unitConversionDao;
	
	 @PersistenceContext
	    EntityManager entityManager;
	 
	 @BeforeMethod() 
	 public void setUp() {
		 unitConversionDao = new UnitConversionDaoImpl();
		  JpaUnitils.injectEntityManagerInto(unitConversionDao);
	 }
	 
	 @Test
	 public void getAllUnitConversions() {
//		 List<UnitConversion> unitConversions = 
//			 entityManager.createNamedQuery(MyNamedQueries.UNIT_CONVERSION_FIND_ALL).getResultList();
		 ArrayList<UnitConversion> unitConversions = (ArrayList)unitConversionDao.getAllUnitConversion();
//		Assert.assertNotEquals(unitConversions, new  ArrayList<UnitConversion>());
		 for(UnitConversion unit : unitConversions) {
//			 Assert.assertNull(unit);
			 logger.info("unit name :" + unit.getName());
		 }
	 }
}
