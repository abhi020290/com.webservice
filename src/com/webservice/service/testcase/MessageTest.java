package com.webservice.service.testcase;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.webservice.database.DataBaseEntity;
import com.webservice.message.Messages;
import com.webservice.service.MessageService;

public class MessageTest {

	private static  MessageService mservice;
	private int count;
	private static Map<Long,Messages> messages ;

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		messages = DataBaseEntity.getMessages();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mservice = new MessageService();
		count = messages.size();
		}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMessageService() {
		assertEquals(count,6);	
	}

	@Test
	public void testGetAllMessages() {
		assertEquals(6,mservice.getAllMessages().size());
	}

	@Test
	public void testGetMessageById() {
		assertEquals("TCS",mservice.getMessageById(1).getAuthor());
	}

	@Test
	public void testGetDeleteById() {
		mservice.getDeleteById(1);
		assertEquals(5,mservice.getAllMessages().size());  
	}

	@Test
	public void testSaveMessage() {
		Messages message = new Messages();
		message.setAuthor("TCS");
		message.setMessage("Junit Test Messages");
		message.setCreated(new Date());
		message.setId(mservice.getAllMessages().size()+1);
		mservice.saveMessage(message);
		assertEquals("TCS",mservice.getMessageById(message.getId()).getAuthor());

		}

	@Test
	public void testUpdateMessage() {

		Messages message = mservice.getMessageById(1);
		message.setAuthor("Junit Update test");
		mservice.updateMessage(message);
		assertEquals("Junit Update test",mservice.getMessageById(1).getAuthor());
	}

	@Test
	public void testGetMessageFromYear() {
     assertEquals(6, mservice.getMessageFromYear(2016).size());
	}

	@Test
	public void testGetMessageLimit() {
		assertEquals(2, mservice.getMessageLimit(2, 4).size());
	}

}
