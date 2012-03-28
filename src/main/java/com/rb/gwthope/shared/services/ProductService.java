package com.rb.gwthope.shared.services;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.rb.gwthope.shared.dto.Product;
import com.rb.gwthope.shared.dto.UnitConversion;

@RemoteServiceRelativePath("springGwtServices/productService")
public interface ProductService extends RemoteService{
	
	ArrayList<UnitConversion> getDefaultUnits();
	Product saveProduct(Product product);
	Product getProduct(Long productId);

}
