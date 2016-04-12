package com.webservice.database;

import java.util.HashMap;
import java.util.Map;

import com.webservice.message.Messages;
import com.webservice.message.Profile;

public class DataBaseEntity {

	private static Map<Long,Messages> messages = new HashMap<Long,Messages>();
	private static Map<String,Profile> profiles = new HashMap<String,Profile>();
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}

	public static Map<Long, Messages> getMessages() {
		return messages;
	}
	
}
