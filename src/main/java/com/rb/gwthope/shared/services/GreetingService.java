package com.rb.gwthope.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("springGwtServices/greetingService")
public interface GreetingService extends RemoteService {
  String greetServer(String name) throws IllegalArgumentException;
}
