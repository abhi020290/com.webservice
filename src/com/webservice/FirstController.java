package com.webservice;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/first")
public class FirstController {
	
	@Path("/plain")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public String TextStatus(){
		  return "This is A String responce Web Services";
	  }

	@Path("/xml")	
	@GET
	@Produces(MediaType.TEXT_XML)
	  public String XmlStatus(){
		   return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	  }

	@Path("/html")	
	@GET
	@Produces(MediaType.TEXT_HTML)
	  public String HtmlStatus(){
		   return "<H1>This is HTML sample return</H1>";
	  }
	
	@Path("/{stringmess}")	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	  public Response message(@PathParam("stringmess")String message){
		
		String messageNew = "This is a Dynamic message: "+message;
		 
		return Response.status(200).entity(messageNew).build();

	  }
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Track getTrackInJSON() {

		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");

		return track;

	}

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Track track) {
		String result = "Track saved : " + track;
		return Response.status(201).entity(result).build();
		
	}
}
