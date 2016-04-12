package com.webservice.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
//import javax.ws.rs.BeanParam;
import javax.ws.rs.core.UriInfo;

@Path("/injectParam")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoParam {

	@GET
	@Path("/matrix")
	public String getMatrixParam(@MatrixParam("matrixData")String matrix){
		return "This is Demo for Matrix param type "+ matrix;
		
	}
	@GET
	@Path("/header")
	public String getHeaderParam(@HeaderParam("headerData")String header){
		return "This is Demo for Header param type "+ header;
	}
	
	@GET
	@Path("/cookie")
	public String getCookieParam(@CookieParam("cookieData")String cookie){
		return "This is Demo for Cookie param type "+ cookie;
	}

	@GET
	@Path("/withoutbean")
	public String getMessageWithoutBean(@CookieParam("cookieData")String cookie,
								 @HeaderParam("headerData")String header,
								 @MatrixParam("matrixData")String matrix){
		return "Matrix demo "+matrix+"Header demo "+header+"Cookie demo"+cookie;
	}
	
//Below is valid from JAX-RS 2.0 onwards
	
	/*@GET
	@Path("/withbean")
	public String getMessageWithBean(@BeanParam FilterBean filterBean){
		
		return "Cookies demo "+filterBean.getCookie()+
				"Header demo "+filterBean.getHeader()+
				"Matrix demo"+filterBean.getMatrix();
		
	}
	*/
	
	//Context and HttpHeaders
	@GET
	@Path("/context")
   public String getContext(@Context UriInfo uriInfo,@Context HttpHeaders httpheaders)	{
		String uri = uriInfo.getRequestUri().toString();
		String header = httpheaders.getCookies().toString();
		return "URI " + uri + "Header "+ header;
	}
	
	@GET
	@Path("/uri")
   public Response getURL(@Context UriInfo uriInfo,@Context HttpHeaders httpheaders)	{
		String uri = uriInfo.getRequestUri().toString();
		String header = httpheaders.getCookies().toString();
		URI Location = uriInfo.getAbsolutePathBuilder().path(header).build();
		return Response.created(Location).build();
 }
	
}

