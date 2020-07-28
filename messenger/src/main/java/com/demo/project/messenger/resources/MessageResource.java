package com.demo.project.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.demo.project.messenger.model.Message;
import com.demo.project.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService msgService = new MessageService();
	
	@GET
	public List<Message> getMessages() {
		return msgService.getMessages();
	}
	
	@POST
	public Message addMessage(Message message) {
		return msgService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return msgService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id) {
		return msgService.removeMessage(id);
	}
	
	
	@GET
	@Path("/{messageId}")
	public Message test(@PathParam("messageId") long messageId) {
		return msgService.getMessage(messageId);
		
	}
}
