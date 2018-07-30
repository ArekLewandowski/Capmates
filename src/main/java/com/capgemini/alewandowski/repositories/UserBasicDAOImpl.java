package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.RankingEntity;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.interfacesDAO.UserBasicDAO;

@Repository
public class UserBasicDAOImpl implements UserBasicDAO {
	List<User> listOfUserBasicData;
	int users;

	public UserBasicDAOImpl() {
		super();
		this.listOfUserBasicData = new ArrayList<>();
		listOfUserBasicData.add(new User("Arek", "Le"));
		listOfUserBasicData.get(0).setUserId(0);
		listOfUserBasicData.add(new User("Madzia", "Fra"));
		listOfUserBasicData.get(1).setUserId(1);
		listOfUserBasicData.add(new User("John", "Doe"));
		listOfUserBasicData.get(2).setUserId(2);
		listOfUserBasicData.add(new User("Arek", "Leo"));
		listOfUserBasicData.get(3).setUserId(3);
		listOfUserBasicData.get(3).setEmailAddres("cos@cos.pl");		
		listOfUserBasicData.add(new User("Arek", "Leo"));
		listOfUserBasicData.get(4).setUserId(4);
		listOfUserBasicData.get(4).setEmailAddres("cosInnego@cos.pl");		
		users = 5;
	}

	@Override
	public User addUser(User user) {
		user.setUserId(users);
		this.listOfUserBasicData.add(user);
		users++;
		return user;
	}

	@Override
	public User getUser(int id) throws NoUserIdInDataBase {
		User gettedUser = getListIdByUserId(id);
		return gettedUser;
	}

	@Override
	public List<User> getUsers() {
		return listOfUserBasicData;
	}

	@Override
	public User editUser(int id, User editedUser) throws NoUserIdInDataBase {
		User editUser = getListIdByUserId(id);
		listOfUserBasicData.indexOf(editUser);
		editedUser.setUserId(id);
		listOfUserBasicData.set(id, editedUser);
		return editUser;
	}

	@Override
	public List<RankingEntity> getRankingData() {
		List<RankingEntity> rankingListData = new ArrayList<>();
		for (User user : this.listOfUserBasicData) {
			rankingListData.add(new RankingEntity(user.getUserId(), user.getFirstName(), user.getLastName()));
		}
		return rankingListData;
	}

	@Override
	public void deleteUser(int id) {
		listOfUserBasicData.remove(id);
	}

	@Override
	public User getUserByListId(int listId) {
		return listOfUserBasicData.get(listId);
	}


	// private
	private User getListIdByUserId(int userId) throws NoUserIdInDataBase {
		User user = listOfUserBasicData.stream().filter(x -> x.getUserId() == userId).findFirst().get();
		if (user != null) {
			return user;
		} else {
			throw new NoUserIdInDataBase();
		}
	}

	@Override
	public List<User> search(String firstName, String lastName, String email) {
		List<User> searchedUsers = new ArrayList<>();
		for (User user : listOfUserBasicData) {
			if ((firstName==null || user.getFirstName().equals(firstName)) &&
					(lastName==null || user.getLastName().equals(lastName)) && 
					(email==null || email.equals(user.getEmailAddres()))) {
				searchedUsers.add(user);
			}
		}
		return searchedUsers;
	}

}