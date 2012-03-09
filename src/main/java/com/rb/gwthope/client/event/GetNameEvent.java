package com.rb.gwthope.client.event;


import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.GwtEvent.Type;

public class GetNameEvent extends GwtEvent<GetNameHandler> {
	private static Type<GetNameHandler> TYPE;
	
	public static Type<GetNameHandler> getType() {
		return TYPE != null ? TYPE : (TYPE = new Type<GetNameHandler>());
	}

	public GetNameEvent() {
	}

	@Override
	public final Type<GetNameHandler> getAssociatedType() {
		return getType();
	}

	@Override
	protected void dispatch(GetNameHandler handler) {
		handler.onGetName(this);
	}

	
}
