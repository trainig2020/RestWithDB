package com.yaswanth.messenger.dao;

import java.util.List;

import com.yaswanth.messenger.model.Profile;

public interface ProfileDao {
	
	
	int savProfile(Profile profile);
	List<Profile> getAllProfiles();
	Profile getProfile(String profName);
	
	int updateProfile(Profile profile);
	int deleteProfile(String profName);
	

}
