package com.rb.gwthope.server.services;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rb.gwthope.server.dao.UserDAO;
import com.rb.gwthope.shared.dto.User;
import com.rb.gwthope.shared.services.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	@PostConstruct
	public void init() throws Exception {
	}
	
	@PreDestroy
	public void destroy() {
	}

	public User findUser(Long userId) {
		return userDAO.findById(userId);
	}

	public boolean saveUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	

}
