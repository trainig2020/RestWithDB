package com.yaswanth.messenger.dao;

import java.util.List;

import com.yaswanth.messenger.model.Comment;

public interface CommentDao {
	
	Comment getComms(int messId);
	
	Comment getComment(int messageId,int commentId);
	
	int saveComms(Comment comment);
	
	int updateComms(Comment comment);
	
	int deleComms(int messId,int commId);

}
