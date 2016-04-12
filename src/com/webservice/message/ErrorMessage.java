package com.webservice.message;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {

	private String errroMessage;
	private int errorCode;
	private String description;
	
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorMessage(String errroMessage, int errorCode, String description) {
		super();
		this.errroMessage = errroMessage;
		this.errorCode = errorCode;
		this.description = description;
	}

	public String getErrroMessage() {
		return errroMessage;
	}

	public void setErrroMessage(String errroMessage) {
		this.errroMessage = errroMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
