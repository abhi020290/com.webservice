package com.webservice.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.webservice.message.Messages;
import com.webservice.service.MessageService;

@Path("/resource")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class MessageResource {

	MessageService service  = new MessageService();
	
	@GET
	@Path("/allMessages")
	public List<Messages> getMessages(@QueryParam("year") int year,
									  @QueryParam("start") int start,
									  @QueryParam("size") int size){
		if (year > 0 ){
			return service.getMessageFromYear(year);
		}
		if(start > 0 && size > 0){
			return service.getMessageLimit(start, size);	
		}
		return service.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Messages getMessages(@PathParam("messageId") long id){
		return service.getMessageById(id);
	}
	
	@POST
	public Messages saveMessage(Messages addMessage){
		return service.saveMessage(addMessage);
	}
	
	@PUT
	@Path("/{messageId}")
	public Messages updateMessage(@PathParam("messageId")long id , Messages addMessage){
		addMessage.setId(id);
		return service.updateMessage(addMessage);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Messages deleteMessage(@PathParam("messageId")long id){
		return service.getDeleteById(id);
	}
	@GET
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
		
	}
}
