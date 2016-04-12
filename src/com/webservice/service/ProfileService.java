package com.webservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.webservice.database.DataBaseEntity;
import com.webservice.message.Profile;

public class ProfileService {

Map<String,Profile> profiles = DataBaseEntity.getProfiles();
	

	public ProfileService(){
		profiles.put("abhi020290", new Profile(1,"abhi020290","Abhishek", "Singhal"));
		profiles.put("john90", new Profile(2,"john90","John", "Hasting"));
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}

	public  Profile deleteProfile(String profileName){
		return profiles.remove(profileName);
	}
	
	
	public  Profile addProfile(Profile profile){
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	
}
