package com.demo.project.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.demo.project.messenger.model.Message;
import com.demo.project.messenger.model.Profile;

public class DataBaseClass {
private static Map<Long, Message> messages = new HashMap<Long, Message>();
private static Map<Long, Profile> profiles = new HashMap<Long, Profile>();


public static Map<Long, Message> getMessages(){
	return messages;
}

public static Map<Long, Profile> getProfiles(){
	return profiles;
}
}
