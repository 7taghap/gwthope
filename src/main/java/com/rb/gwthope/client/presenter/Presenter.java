package com.rb.gwthope.client.presenter;

import com.rb.gwthope.client.view.Display;



public interface Presenter<D extends Display> {

	void bind();

	void unbind();

	D getDisplay();

}