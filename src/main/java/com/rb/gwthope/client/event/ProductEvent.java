package com.rb.gwthope.client.event;

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class ProductEvent extends GwtEvent<ProductEventHandler>{

	public static Type<ProductEventHandler> TYPE = new Type<ProductEventHandler>();
	
	@Override
	protected void dispatch(ProductEventHandler arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<ProductEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return null;
	}

}
