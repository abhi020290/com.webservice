package com.webservice.service.testcase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.webservice.database.DataBaseEntity;
import com.webservice.message.Messages;
import com.webservice.service.MessageService;

public class MessageServiceTest {

	private static Map<Long,Messages> messages;
	private int countMessage;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		messages = DataBaseEntity.getMessages();
		new MessageService();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		countMessage = messages.size();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMessageService() {
		assertEquals(countMessage,6);	
	}

	@Test
	public void testGetAllMessages() {
		List<Messages> messageList =  new ArrayList<Messages>(messages.values());
		int size = messageList.size();
		System.out.println(messageList.size());
		assertEquals(6,size);
	}

	@Test
	public void testGetMessageById() {
	   Messages message = messages.get(1);
       Date text = message.getCreated();
       assertEquals(new Date(),text);
	}

	@Test
	public void testGetDeleteById() {
		messages.remove(1);
		int size = messages.size();
		assertEquals(5,size);
	       
	}

	@Test
	public void testSaveMessage() {
		Messages message = new Messages();
		message.setAuthor("TCS");
		message.setMessage("Junit Test Messages");
		message.setCreated(new Date());
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		System.out.println(messages.get(message.getAuthor()));
		assertEquals("TCS",messages.get(message.getId()).getAuthor());

		}

	@Test
	public void testUpdateMessage() {
		Messages message = messages.get(1);
		message.setAuthor("Junit Test Update");
		messages.put(message.getId(),message);
		assertEquals("Junit Test Update",messages.get(message.getId()).getAuthor());
	}

	@Test
	public void testGetMessageFromYear() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMessageLimit() {
		fail("Not yet implemented");
	}

}
