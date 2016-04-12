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
import javax.ws.rs.core.MediaType;

import com.webservice.message.Comment;
import com.webservice.service.CommentService;

@Path("/")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)

public class CommentResource {
	
	private CommentService service = new CommentService();
	
	@GET
	public List<Comment> getAllMessageComments(@PathParam("messageId") long id	){
		return service.getAllMessageComments(id);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long id, Comment comment){
        return service.saveComment(id, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId,Comment comment){
		comment.setId(commentId);
		return service.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void removeComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
		service.removeComment(messageId, commentId);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getComment(@PathParam("messageId") long messageId,@PathParam("commentId") long commentId){
		return service.getComment(messageId, commentId);
	}
	
	
	@GET
	@Path("Test1")
	public String test(){
		return "Sub Resource";
	}
	
	@GET
	@Path("/Test1/{commentId}")
	public String test2(@PathParam("commentId")String commentId,
						@PathParam("messageId")String messageId){
		return "Comment Id: "+commentId+ " Message Id: "+messageId;
	}
	
	
}
