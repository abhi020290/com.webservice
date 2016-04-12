package com.webservice.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.webservice.message.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage err = new ErrorMessage(ex.getMessage(),500,"http://google.com");
		return Response.status(Status.NOT_FOUND).entity(err).build();
	}

}
