package com.rb.gwthope.client.presenter.impl;



import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.inject.Inject;
import com.rb.gwthope.client.event.EventBus;
import com.rb.gwthope.client.event.GetNameEvent;
import com.rb.gwthope.client.presenter.BasePresenter;
import com.rb.gwthope.client.presenter.GreetingPresenter;
import com.rb.gwthope.client.presenter.GreetingPresenter.Display;

public class GreetingPresenterImpl extends BasePresenter<GreetingPresenter.Display>
implements GreetingPresenter{

	@Inject
	public GreetingPresenterImpl(EventBus eventBus, Display display) {
		super(eventBus, display);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void bind() {

		super.bind();

		registerHandler(display.getGetNameClickHandlers().addClickHandler(
				new ClickHandler() {
					public void onClick(ClickEvent event) {
						eventBus.fireEvent(new GetNameEvent());
					}
				}));

	}
	
	

	
}
