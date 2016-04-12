package com.webservice.message;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	
	private long id;
    private String message;
    private String author;
	private Date created;
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Comment(long id, String message, String author, Date created) {
		super();
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = created;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
  
  
  
  
  
  
}
