package com.rb.gwthope.server.dao;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;

import com.rb.gwthope.shared.dto.User;

public class UserDAO extends JpaDAO<Long, User> {

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@PostConstruct
	public void init() {
		super.setEntityManagerFactory(entityManagerFactory);
	}
}
