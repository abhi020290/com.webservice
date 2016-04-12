package com.webservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.webservice.database.DataBaseEntity;
import com.webservice.message.Comment;
import com.webservice.message.Messages;

public class CommentService {

	Map<Long,Messages> messages = DataBaseEntity.getMessages();
	
	public List<Comment> getAllMessageComments(long messageId){
	Map<Long, Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId,long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.get(commentId);
	}

	public  Comment removeComment(long messageId,long commentId){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		return comments.remove(comments);
	}
	
	
	public  Comment saveComment(long messageId, Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment updateComment(long messageId ,Comment comment){
		Map<Long, Comment> comments = messages.get(messageId).getComments();
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	
	
}
