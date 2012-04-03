package com.rb.gwthope.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.orm.jpa.JpaUnitils;

import com.rb.gwthope.server.dao.ProductDao;
import com.rb.gwthope.server.dao.impl.ProductDaoImpl;
import com.rb.gwthope.shared.dto.Product;
import com.rb.gwthope.shared.dto.ProductCategory;
import com.rb.gwthope.shared.dto.ProductDtl;
import com.rb.gwthope.shared.dto.Status;
import com.rb.gwthope.shared.dto.UnitConversion;


public class ProductDaoImplTest extends DaoImplTest {

	public ProductDaoImplTest() {
		super();
	}
	
	ProductDao productDao;
	
	@BeforeMethod
	public void setup() {
		productDao = new ProductDaoImpl();
		JpaUnitils.injectEntityManagerInto(productDao);
		
	}
	
	
	@Test(enabled=true)
	public void createProduct() {
		//product details
		Set<ProductDtl> dtls = new HashSet<ProductDtl>();
		
		ProductDtl dtl1 = new ProductDtl();
		Status status = new Status();
		status.setStatusId(1);
		dtl1.setCreatedBy("testng");
		dtl1.setCreatedDate(new Date());
		dtl1.setLastUpdatedBy("testng");
		dtl1.setPrice(2.50);
		dtl1.setPriceType(1);
		dtl1.setQtyOnHand(100f);
		dtl1.setSellingQty(5.5f);
		dtl1.setSugPrice(5.5f);
		dtl1.setStatus(status);
		UnitConversion dtlUnit = new UnitConversion(); //query if dili slow
		dtlUnit.setId(2);
		dtl1.setUnitConversion(dtlUnit);
		dtls.add(dtl1);
		
		Product product = new Product();
		ProductCategory category = new ProductCategory(); //query if dili slow
		category.setProductCategoryId(1);
		product.setCategory(category);
		product.setCreatedBy("testng");
		product.setCreatedDate(new Date());
		product.setProductDesc("product test");
		product.setProductName("test product");
		product.setProductType(1);
		product.setShelf("in da room");
		product.setTotalQtyOnHand(10);
		UnitConversion unit = new UnitConversion(); //query if dili slow
		unit.setId(1);
		unit.setName("g");
		product.setUnitConversion(unit);
		
		
		product.setProductDtls(dtls);
		
		entityManager.persist(product);
		product = productDao.findById(1000);
		System.out.println(product.getUnitConversion().getName());
		
	}
	
	@Test(enabled=false)
	public void getProduct() {
		Product product = productDao.findById(1000);
		System.out.println(product.getUnitConversion().getName());
	}
}
