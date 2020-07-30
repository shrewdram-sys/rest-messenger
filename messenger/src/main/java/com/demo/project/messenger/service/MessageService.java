package com.demo.project.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.demo.project.messenger.database.DataBaseClass;
import com.demo.project.messenger.exception.DataNotFoundException;
import com.demo.project.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> messages = new DataBaseClass().getMessages();

	public MessageService() {
		messages.put(1L, new Message(1, "Hey", "Vijay"));
		messages.put(2L, new Message(2, "Good", "Kumar"));
	}

	public List<Message> getMessages() {
		return new ArrayList<Message>(messages.values());
	}

	public Message getMessage(long id) {
		Message message = messages.get(id);
		if(message == null)
			throw new DataNotFoundException("Message with id "+id+" not found");
		return message;
	}

	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<Message>();
		Calendar cal = Calendar.getInstance();
		for (Message message: messages.values()){
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year){
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<Message>(messages.values());
		if (start + size > list.size()) return new ArrayList<Message>();
		return list.subList(start, start + size);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (message.getId() == 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
