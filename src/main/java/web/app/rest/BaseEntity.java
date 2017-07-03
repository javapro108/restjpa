package web.app.rest;

import java.util.ArrayList;
import java.util.List;

import web.app.common.AppMessage;

public class BaseEntity {
	private List<AppMessage> messages = new ArrayList<AppMessage>();

	public void addMessage(String message){
		AppMessage appMessage = new AppMessage();
		appMessage.setType("Error");
		appMessage.setMessage(message);		
		messages.add(0, appMessage);
	}

	public void addMessage(String message, String type){
		AppMessage appMessage = new AppMessage();
		appMessage.setType(type);
		appMessage.setMessage(message);
		messages.add(0, appMessage);
	}	
	
	public List<AppMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<AppMessage> messages) {
		this.messages = messages;
	}
	
}
