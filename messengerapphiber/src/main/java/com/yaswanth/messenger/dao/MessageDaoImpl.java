package com.yaswanth.messenger.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yaswanth.messenger.model.Message;
import com.yaswanth.messenger.util.HibernateUtil;

public class MessageDaoImpl implements MessageDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

	@Override
	public int saveMessage(Message message) {
		Session session = sessionFactory.openSession();
			session.beginTransaction();
			//message.setCreated(new Date());
			session.save(message);
			session.getTransaction().commit();
		return 0;
	}

	@Override
	public List<Message> getAllMessages() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		List<Message> messList = session.createQuery("FROM Message").list();
		System.out.println("Department List");
		for (Message message : messList) {
			System.out.println("values in dao message " + message.getAuthor());
		}
		session.getTransaction().commit();
		return messList;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Message getMessage(int messId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Message mess = (Message) session.get(Message.class, messId);

		session.getTransaction().commit();
		return mess;
	}

	@Override
	public int updateMessage(Message message) {
		Session session = sessionFactory.openSession();
		message.setCreated(new Date());
		session.beginTransaction();
		session.update(message);
		session.getTransaction().commit();
		return 0;

	}

	@Override
	public int deleteMessage(int messId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Message mess = (Message) session.get(Message.class, messId);
		session.delete(mess);
		session.getTransaction().commit();

		return 0;
	}

}
