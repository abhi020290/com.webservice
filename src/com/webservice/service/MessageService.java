package com.webservice.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.webservice.database.DataBaseEntity;
import com.webservice.exception.DataNotFoundException;
import com.webservice.message.Messages;

public class MessageService {

	Map<Long,Messages> messages = DataBaseEntity.getMessages();
	
	public MessageService(){
		messages.put(1L,new Messages(1L,"Hello india!","TCS", new Date()));
		messages.put(2L,new Messages(2L,"Hello india!","TCS", new Date()));
		messages.put(3L,new Messages(3L,"Hello india!","TCS", new Date()));
		messages.put(4L,new Messages(4L,"Hello india!","TCS", new Date()));
		messages.put(5L,new Messages(5L,"Hello india!","TCS", new Date()));
		messages.put(6L,new Messages(6L,"Hello india!","TCS", new Date()));
	}
	
	public List<Messages> getAllMessages(){
		return new ArrayList<Messages>(messages.values());
	}
	
	public Messages getMessageById(long id){
		Messages message = messages.get(id);
		if(message == null){
			throw new DataNotFoundException();
		}
		return message;
	}

	public  Messages getDeleteById(long id){
		return messages.remove(id);
	}
	
	
	public  Messages saveMessage(Messages mes){
		mes.setId(messages.size()+1);
		messages.put(mes.getId(),mes);
		return mes;
	}
	
	public Messages updateMessage(Messages mess){
		Messages message = messages.put(mess.getId(),mess);
		/*ErrorMessage err = new ErrorMessage("Data not found",500,"http://google.com");
		Response response = Response.status(Status.NOT_FOUND).entity(err).build();*/
		/*if (message == null){
			throw new WebApplicationException(response);
			//throw new  NotFoundException();
		}*/
		return message;
	}
	
	public List<Messages> getMessageFromYear(int year){
		
		List<Messages> messageList =  new ArrayList<Messages>(messages.values());
		List<Messages> newMessageList = new ArrayList<Messages>();
		Calendar cal = Calendar.getInstance();
		for(Messages message : messageList){
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year){
				newMessageList.add(message);
			}
		}
		return newMessageList;
	}
	public List<Messages> getMessageLimit(int start , int size){
		List<Messages> messageList =  new ArrayList<Messages>(messages.values());
		return messageList.subList(start, size);
		
	}
}
