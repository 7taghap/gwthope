package com.rb.gwthope.client.view.presenter;

import com.rb.gwthope.client.view.Display;

/**
 * 
 * @author caburnar
 *
 * @param <D> generic Display
 */
public interface Presenter<D extends Display> {

	void bind();
	void unbind();
	D getDisplay();
}
