package com.webservice.message;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {

	 	public long id;
	    public String profileName;
	    public String firstName;
	    public String lastName;
	   
	    
	    public Profile() {} 
	    
		public Profile(long id,String profileName, String firstName, String lastName
				) {
			this.profileName = profileName;
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = id;
		}

		public String getProfileName() {
			return profileName;
		}

		public void setProfileName(String profileName) {
			this.profileName = profileName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

	   
}
