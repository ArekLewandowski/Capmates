package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.interfaces.UserBasicDAO;

@Repository
public class UserBasicDAOImpl implements UserBasicDAO{
	List<User> listOfUserBasicData;
	
	public UserBasicDAOImpl() {
		super();
		this.listOfUserBasicData = new ArrayList<>();
	}

	@Override
	public User addUser(User user) {
		this.listOfUserBasicData.add(user);
		return user;
	}

	@Override
	public User getUser(int id) {	
		return this.listOfUserBasicData.get(id);
	}

	@Override
	public User editUser(int id, User editedUser) {
		this.listOfUserBasicData.set(id, editedUser);
		return null;
	}

	@Override
	public List<User> getRankingData() {
		List<User> rankingListData = new ArrayList<>();
		for (User user : this.listOfUserBasicData) {
			rankingListData.add(new User(user.getUserId(), user.getFirstName(), user.getLastName()));	
		}
		return rankingListData;
	}

	@Override
	public void deleteUser(int id) {
		listOfUserBasicData.remove(id);
	}

}












