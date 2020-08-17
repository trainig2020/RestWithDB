package com.yaswanth.messenger.service;

import java.util.List;

import com.yaswanth.messenger.dao.CommentDao;
import com.yaswanth.messenger.dao.CommentdaoImpl;
import com.yaswanth.messenger.model.Comment;
import com.yaswanth.messenger.model.Message;

public class CommentServicce {
	
	CommentDao cmDao = new CommentdaoImpl();
	
	public Comment getAllComms(int messId){
		
		Comment lisd = cmDao.getComms(messId);

		return lisd;}
		

	public int saveCom(Comment comment)
	{
		cmDao.saveComms(comment);
		
		return 0;
	}
	
	public int updateComm(Comment comment)
	{
		cmDao.updateComms(comment);
		return 0;
	}
	
	public int deleComm(int messId,int commId)
	{
		cmDao.deleComms(messId, commId);
		return 0;
	}
	
	public Comment getComment(int messageid,int commentid) {
		Comment comment = cmDao.getComment(messageid, commentid);
		return comment;
	}
	
}
