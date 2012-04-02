package com.rb.gwthope.server;

import java.util.Date;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.orm.jpa.JpaUnitils;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;
import org.unitils.spring.annotation.SpringBeanByName;

import com.rb.gwthope.server.dao.UserDao;
import com.rb.gwthope.server.dao.impl.UserDaoImpl;
import com.rb.gwthope.shared.dto.User;

//@DataSet("TagManagerTest.xml")
@JpaEntityManagerFactory(persistenceUnit="testPU", configFile="META-INF/persistence-test.xml")
@SpringApplicationContext({"classpath:spring-config.xml","classpath:test-config.xml"})
public class UserDaoImplTest extends UnitilsTestNG {
	 private static Logger logger = Logger.getLogger(UserDaoImplTest.class.getName());
    @PersistenceContext
    EntityManager entityManager;
	
//   @SpringBean("userDao")
	UserDao userDao;
    
    @BeforeMethod
    public void setUp() {
        userDao = new UserDaoImpl();
        JpaUnitils.injectEntityManagerInto(userDao);
    	Assert.assertNotNull(userDao);
    }
  
    @Test(enabled=false)
    public void testFindById() {
    	logger.info("enityt manager :" + entityManager);
    	Assert.assertNotNull(userDao);
       User users =userDao.findById(1);
       logger.info(users.toString());
//        assertPropertyLenientEquals("firstName", Arrays.asList("John", "Jane"), users);
    }
    @Test
    public void insertUser() {
    	User user = new User();
    	user.setUsername("admin");
    	user.setFullname("Rey Bryan");
    	user.setPassword("helloworld");
    	user.setStatus(1);
//    	user.set
    	user.setCreatedDate(new Date());
    	user.setUpdateDate(new Date());
    	
    }

}
