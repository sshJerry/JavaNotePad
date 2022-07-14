package com.service;

import java.util.HashMap;
import java.util.Map;

public class UserService {
	
	Map<String,String> map;
	{
		map =new HashMap<>();
		map.put("harry", "potter123");
		map.put("ronald", "weasley123");
	}
	
	public boolean validateCredentials(String username, String password) {
		boolean isPresent = false;
		for (String key: map.keySet()) {
			if(key.equals(username)) {
				isPresent = true;
				break;
			}
		}
		if(isPresent) {
			String pass =map.get(username);
			if (pass.equals(password))
				return true;
		}
		return false;
	}
}
