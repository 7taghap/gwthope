package com.rb.gwthope.client;

import com.rb.gwthope.client.event.GreetingEvent;
import com.rb.gwthope.client.event.GreetingEventHandler;
import com.rb.gwthope.client.gin.ContactsGinjector;
import com.rb.gwthope.client.gin.HopeInjector;
import com.rb.gwthope.client.place.ContactPlace;
import com.rb.gwthope.client.view.SideMenuView;
import com.rb.gwthope.client.view.presenter.AppPlaceFactory;
import com.rb.gwthope.client.view.presenter.AppPlaceHistoryMapper;

import com.rb.gwthope.shared.FieldVerifier;
import com.rb.gwthope.shared.dto.User;
import com.rb.gwthope.shared.services.GreetingService;
import com.rb.gwthope.shared.services.GreetingServiceAsync;
import com.rb.gwthope.shared.services.UserService;
import com.rb.gwthope.shared.services.UserServiceAsync;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class gwthope implements EntryPoint {
  /**
   * The message displayed to the user when the server cannot be reached or
   * returns an error.
   */
  private static final String SERVER_ERROR = "An error occurred while "
      + "attempting to contact the server. Please check your network "
      + "connection and try again.";

  /**
   * Create a remote service proxy to talk to the server-side Greeting service.
   */
  private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
  
  /**
   * Creeate a remote service proxy for User
   * 
   */
  private final UserServiceAsync userService = GWT.create(UserService.class);

  private final Messages messages = GWT.create(Messages.class);

  /**
   * This is the entry point method.
   */
	private SimplePanel appWidget = new SimplePanel();
	
	private com.rb.gwthope.client.gin.ContactsGinjector injector = GWT.create(ContactsGinjector.class);
  public void onModuleLoad() {
	  ContactClientFactory();
  }
  private void ContactClientFactory() {
		EventBus eventBus = injector.getEventBus();
		PlaceController placeController = injector.getPlaceController();

		ActivityMapper activityMapper = injector.getActivityMapper();
		ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
		activityManager.setDisplay(appWidget);

		AppPlaceFactory factory = injector.getAppPlaceFactory();
		ContactPlace defaultPlace = factory.getContactPlace();
//		MenuPlace menuPlace = factory.getMenuPlace();
		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);
		historyMapper.setFactory(factory);
		
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);
		System.out.println(factory.getContactPlace().getPlaceName());
		RootPanel.get("sidebar").add(new SideMenuView());
		RootPanel.get("content").add(appWidget);
		
		historyHandler.handleCurrentHistory();
		logEvent(eventBus);
  }
  
  
  private void simplePresenter() {
	  HandlerManager eventBus = new HandlerManager(null);
	  AppController appController = new AppController(eventBus);
	  appController.go(RootPanel.get());
  }
  
  
  private void logEvent(EventBus eventBus) {
//	  Window.alert(eventBus.getHandlerCount(GreetingEvent.TYPE)+"");
//	  eventBus.
	  eventBus.addHandler(GreetingEvent.TYPE,new GreetingEventHandler() {
		
		public void onGetName(GreetingEvent event) {
			Window.alert(event.toDebugString());
			GWT.log(event.toDebugString(), null);
			
		}
	});
  }

  public void greetingSample() {
    final Button sendButton = new Button( messages.sendButton() );
    final TextBox nameField = new TextBox();
    nameField.setText( messages.nameField() );
    final Label errorLabel = new Label();

    // We can add style names to widgets
    sendButton.addStyleName("sendButton");

    // Add the nameField and sendButton to the RootPanel
    // Use RootPanel.get() to get the entire body element
    RootPanel.get("nameFieldContainer").add(nameField);
    RootPanel.get("sendButtonContainer").add(sendButton);
    RootPanel.get("errorLabelContainer").add(errorLabel);
//    errorLabel.setText("hello debug");
//    RootPanel.get("container").add(sendButton);
    // Focus the cursor on the name field when the app loads
    nameField.setFocus(true);
    nameField.selectAll();

    // Create the popup dialog box
    final DialogBox dialogBox = new DialogBox();
    dialogBox.setText("Remote Procedure Call");
    dialogBox.setAnimationEnabled(true);
    final Button closeButton = new Button("Close");
    // We can set the id of a widget by accessing its Element
    closeButton.getElement().setId("closeButton");
    final Label textToServerLabel = new Label();
    final HTML serverResponseLabel = new HTML();
    VerticalPanel dialogVPanel = new VerticalPanel();
    dialogVPanel.addStyleName("dialogVPanel");
    dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
    dialogVPanel.add(textToServerLabel);
    dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
    dialogVPanel.add(serverResponseLabel);
    dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
    dialogVPanel.add(closeButton);
    dialogBox.setWidget(dialogVPanel);

    // Add a handler to close the DialogBox
    closeButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        dialogBox.hide();
        sendButton.setEnabled(true);
        sendButton.setFocus(true);
      }
    });

    // Create a handler for the sendButton and nameField
    class MyHandler implements ClickHandler, KeyUpHandler {
      /**
       * Fired when the user clicks on the sendButton.
       */
      public void onClick(ClickEvent event) {
        sendNameToServer();
      }

      /**
       * Fired when the user types in the nameField.
       */
      public void onKeyUp(KeyUpEvent event) {
        if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
          sendNameToServer();
        }
      }

      /**
       * Send the name from the nameField to the server and wait for a response.
       */
      private void sendNameToServer() {
        // First, we validate the input.
        errorLabel.setText("");
        String textToServer = nameField.getText();
//        if (!FieldVerifier.isValidName(textToServer)) {
//          errorLabel.setText("Please enter at least four characters");
//          return;
//        }

        // Then, we send the input to the server.
        sendButton.setEnabled(false);
        textToServerLabel.setText(textToServer);
        serverResponseLabel.setText("");
//        greetingService.greetServer(textToServer, new AsyncCallback<String>() {
//          public void onFailure(Throwable caught) {
//            // Show the RPC error message to the user
//            dialogBox.setText("Remote Procedure Call - Failure");
//            serverResponseLabel.addStyleName("serverResponseLabelError");
//            serverResponseLabel.setHTML(SERVER_ERROR);
//            dialogBox.center();
//            closeButton.setFocus(true);
//          }
//
//          public void onSuccess(String result) {
//            dialogBox.setText("Remote Procedure Call");
//            serverResponseLabel.removeStyleName("serverResponseLabelError");
//            serverResponseLabel.setHTML(result);
//            dialogBox.center();
//            closeButton.setFocus(true);
//          }
//        });
        userService.findUser(Integer.parseInt(textToServer), new AsyncCallback<String>() {
        	public void onFailure(Throwable caught) {
              // Show the RPC error message to the user
              dialogBox.setText("Remote Procedure Call - Failure");
              serverResponseLabel.addStyleName("serverResponseLabelError");
              serverResponseLabel.setHTML(SERVER_ERROR);
              dialogBox.center();
              closeButton.setFocus(true);
        	}
        	public void onSuccess(String user) {
              dialogBox.setText("Remote Procedure Call");
              serverResponseLabel.removeStyleName("serverResponseLabelError");
              serverResponseLabel.setHTML(user);
              dialogBox.center();
              closeButton.setFocus(true);
        	}
		});
      }
    }

    // Add a handler to send the name to the server
    MyHandler handler = new MyHandler();
    sendButton.addClickHandler(handler);
    nameField.addKeyUpHandler(handler);
  }
  
  
}
