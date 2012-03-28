package com.rb.gwthope.client.view.widget;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class SimpleWidgetPanel extends LayoutPanel implements AcceptsOneWidget{

	private Widget widget;
	@Override
	public void setWidget(IsWidget arg0) {
		// TODO Auto-generated method stub
		 setOneWidget(asWidgetOrNull(arg0));
	}
	
	private void setOneWidget (Widget w) {
	
		if(w==widget) {
			return;
		}
		if (widget!=null) {
			super.remove(widget);
		}
		widget =w;
		if (w != null) {
			super.add(w);
		}
		
	}

}
