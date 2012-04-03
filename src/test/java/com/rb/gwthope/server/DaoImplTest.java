package com.rb.gwthope.server;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.unitils.UnitilsTestNG;
import org.unitils.orm.jpa.annotation.JpaEntityManagerFactory;
import org.unitils.spring.annotation.SpringApplicationContext;

@JpaEntityManagerFactory(persistenceUnit="testPU", configFile="META-INF/persistence-test.xml")
@SpringApplicationContext({"classpath:spring-config.xml","classpath:test-config.xml"})
public abstract class DaoImplTest extends UnitilsTestNG {
	
	 @PersistenceContext
	 EntityManager entityManager;

}
