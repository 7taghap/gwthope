package com.rb.gwthope.shared.services;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rb.gwthope.shared.dto.User;

@RemoteServiceRelativePath("springGwtServices/userService")
public interface UserService extends RemoteService{

	public String findUser(Integer userId);
//	public List<User> findAll();
//	public boolean saveUser(User user) throws Exception;
}
