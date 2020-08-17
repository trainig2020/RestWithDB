package com.yaswanth.messenger.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.yaswanth.messenger.model.Profile;
import com.yaswanth.messenger.util.HibernateUtil;

public class ProfileDaoImpl implements ProfileDao {

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	@Override
	public int savProfile(Profile profile) {
        Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    session.save(profile);
	    session.getTransaction().commit();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Profile> getAllProfiles() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
        List<Profile> profList = session.createQuery("FROM Profile").list();
        for (Profile profile : profList) {
			System.out.println("values in dao "+profile.getFirstName());
		}
        session.getTransaction().commit();
		return profList;
	}

	@Override
	public Profile getProfile(String profName) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("select * from profile where profileName = :profileName");
        
        query.addEntity(Profile.class);
        query.setString("profileName", profName);
        List<Profile> prof = query.list();
        Profile profile = new Profile(prof.get(0).getProfileId(),prof.get(0).getFirstName(),prof.get(0).getLastName(),prof.get(0).getProfileName(),prof.get(0).getCreated());
     
		return profile;
	}

	@Override
	public int updateProfile(Profile profile) {
       Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    SQLQuery query = session.createSQLQuery("update profile set profileId = :proId,firstName = :firName,lastName = :laName,created = :created where profileName = :profileName");
	    query.addEntity(Profile.class);
	    query.setInteger("proId", profile.getProfileId());
	    query.setString("firName", profile.getFirstName());
	    query.setString("laName", profile.getLastName());
	    query.setDate("created", profile.getCreated());
	    query.setString("profileName", profile.getProfileName());
	    
	   query.executeUpdate();
	    session.getTransaction().commit();
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int deleteProfile(String profName) {
		Session session = sessionFactory.openSession();
        session.beginTransaction();
        SQLQuery query = session.createSQLQuery("delete  from profile where profileName =:profileName");
        
        query.addEntity(Profile.class);
        query.setString("profileName", profName);
        query.executeUpdate();
        session.getTransaction().commit();
      
		return 0;
	}
}
