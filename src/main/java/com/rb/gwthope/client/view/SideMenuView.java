package com.rb.gwthope.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.i18n.client.Constants;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ClientBundle.Source;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LazyPanel;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.rb.gwthope.client.activity.MenuActivity.IMenuViewDisplay;


public class SideMenuView extends Composite implements IMenuViewDisplay{

	public SideMenuView() {
		initWidget(this.onInitialize());
	}
	public Hyperlink hypHome = new Hyperlink("Home","home");
	public Hyperlink hypProduct = new Hyperlink("Product","product");
	public VerticalPanel homePanel = new VerticalPanel();
	public VerticalPanel simplesearchPanel = new VerticalPanel();
	public VerticalPanel advancedsearchPanel = new VerticalPanel();
	public VerticalPanel orderentryPanel = new VerticalPanel();
	public VerticalPanel worklistPanel = new VerticalPanel();
	public VerticalPanel contactusPanel = new VerticalPanel();
	
	public Widget onInitialize() {
		 DecoratedStackPanel stackPanel = new DecoratedStackPanel();
		    stackPanel.setWidth("200px");
		    Anchor achor1 = new Anchor("Product");
		    HorizontalPanel panel1 = new HorizontalPanel();
		    panel1.add(achor1);
		    homePanel.add(createMailItem());
//		    homePanel.add(new Label("Create"));
		    simplesearchPanel.add(this.createFiltersItem());
		    homePanel.add(hypProduct);
		    stackPanel.add(homePanel,getHeaderString(hypHome),true);
		    stackPanel.add(simplesearchPanel,"Product",true);
		    return stackPanel;
	}
	

public HasClickHandlers getHompageButton() {
	return hypHome;
}

public HasClickHandlers getProductButton() {
	// TODO Auto-generated method stub
	return hypProduct;
}

private VerticalPanel createFiltersItem() {
    VerticalPanel filtersPanel = new VerticalPanel();
    filtersPanel.setSpacing(4);
    String[] links = {"create","update","delete"};
    for (int x=0; x < links.length; x++ ){
//    	Hyperlink link = 
    	filtersPanel.add(new Hyperlink(links[x],links[x]));
    }	
    return filtersPanel;
  }


private VerticalPanel createContactsItem() {
    // Create a popup to show the contact info when a contact is clicked
    HorizontalPanel contactPopupContainer = new HorizontalPanel();
    contactPopupContainer.setSpacing(5);
//    contactPopupContainer.add(new Image(images.defaultContact()));
    final HTML contactInfo = new HTML();
    contactPopupContainer.add(contactInfo);
    final PopupPanel contactPopup = new PopupPanel(true, false);
    contactPopup.setWidget(contactPopupContainer);

    // Create the list of contacts
    VerticalPanel contactsPanel = new VerticalPanel();
    contactsPanel.setSpacing(4);
    String[] contactNames = {"Hello","World"};
    String[] contactEmails = {"hello@com.com", "world@com.com"};
    for (int i = 0; i < contactNames.length; i++) {
      final String contactName = contactNames[i];
      final String contactEmail = contactEmails[i];
      final Anchor contactLink = new Anchor(contactName);
      contactsPanel.add(contactLink);

      // Open the contact info popup when the user clicks a contact
      contactLink.addClickHandler(new ClickHandler() {
        public void onClick(ClickEvent event) {
          // Set the info about the contact
          contactInfo.setHTML(contactName + "<br><i>" + contactEmail + "</i>");

          // Show the popup of contact info
          int left = contactLink.getAbsoluteLeft() + 14;
          int top = contactLink.getAbsoluteTop() + 14;
          contactPopup.setPopupPosition(left, top);
          contactPopup.show();
        }
      });
    }
    return contactsPanel;
  }

private Tree createMailItem() {
    Tree mailPanel = new Tree();
    TreeItem mailPanelRoot = mailPanel.addItem("foo@example.com");
//    String[] mailFolders = constants.cwStackPanelMailFolders();
    mailPanelRoot.addItem(" Inbox" );
    mailPanelRoot.addItem(" Inbox" );
    mailPanelRoot.addItem(" Inbox" );
    mailPanelRoot.setState(true);
    return mailPanel;
  }


/**
 * @param hyperlink
 * @return
 */
private String getHeaderString(Hyperlink hyperlink) {
	// Add the image and text to a horizontal panel
	final HorizontalPanel hPanel = new HorizontalPanel();
	hPanel.setSpacing(0);
	hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	hyperlink.setStyleName("StackPanelHeader");

	hPanel.add(hyperlink);

	// Return the HTML string for the panel
	return hPanel.getElement().getString();
}
	

	
	
}
