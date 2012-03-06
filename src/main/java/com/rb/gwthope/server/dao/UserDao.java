package com.rb.gwthope.server.dao;

import com.rb.gwthope.shared.dto.User;

public interface UserDao {

	public User findById(Long userId);
}
