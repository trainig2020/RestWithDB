package com.yaswanth.messenger.dao;

import java.util.List;

import com.yaswanth.messenger.model.Message;

public interface MessageDao {
	
	
	int saveMessage(Message message);
	List<Message> getAllMessages();
	Message getMessage(int messId);
	
	int updateMessage(Message message);
	int deleteMessage(int messId);
	

}
