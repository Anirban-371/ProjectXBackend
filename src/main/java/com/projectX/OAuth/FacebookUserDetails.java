package com.projectX.OAuth;

public class FacebookUserDetails {
	private String jsonString;

	FacebookUserDetails(String fbResponse){
		jsonString = fbResponse;
	}
	public String toString(){
		return jsonString;
	}
}
