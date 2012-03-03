package com.rb.gwthope.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rb.gwthope.shared.dto.User;

@RemoteServiceRelativePath("springGwtServices/userService")
public interface UserService extends RemoteService{

	public User findUser(Long userId);
	public boolean saveUser(User user) throws Exception;
}
