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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.webservice.message.Messages;
import com.webservice.service.MessageService;

@Path("/responseMessage")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class MessageResourceResponse {

MessageService service  = new MessageService();
	
    @GET
	@Path("/test1")
	public String test1(){
	return "This is Response test";
    }
    
    @GET
   	@Path("/test2")
   	public   Response test2(){
   	String test = "This is test2";
   	return Response.status(200).entity(test).build();
   	
       }


	@GET
	@Path("/allMessages")
  public   
	 Response getMessages(@QueryParam("year") int year,
									  @QueryParam("start") int start,
									  @QueryParam("size") int size){
		if (year > 0 ){
			List<Messages> newMessage  = service.getMessageFromYear(year);
			return	Response.status(200).entity(newMessage).build();
		}
		if(start > 0 && size > 0){
			List<Messages> newMessage= service.getMessageLimit(start, size);
			return	Response.status(200).entity(newMessage).build();
		}
		
		return Response.status(200).entity(service.getAllMessages()).build();
	}
	
	@GET
	@Path("/{messageId}")
	public   
 Response getMessages(@PathParam("messageId") long id){
		return Response.status(200).entity(service.getMessageById(id)).build();
	}
	
	@POST
	public   
 Response saveMessage(Messages addMessage){
		return Response.status(Status.CREATED).entity(service.saveMessage(addMessage)).build();
	}
	
	@PUT
	@Path("/{messageId}")
	public   
 Response updateMessage(@PathParam("messageId")long id , Messages addMessage){
		addMessage.setId(id);
		return Response.status(Status.OK).entity(service.updateMessage(addMessage)).build();
	}
	
	@DELETE
	@Path("/{messageId}")
	public   
 Response deleteMessage(@PathParam("messageId")long id){
		return Response.status(Status.OK).entity(service.getDeleteById(id)).build();
		
	}
	
	@Path("/{messageId}/comments")
	public   
 CommentResource getCommentResource(){
		return new CommentResource();
		
	}
	
}
