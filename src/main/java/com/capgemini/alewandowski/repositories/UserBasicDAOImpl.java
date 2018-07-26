package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.RankingEntity;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.interfacesDAO.UserBasicDAO;

@Repository
public class UserBasicDAOImpl implements UserBasicDAO{
	List<User> listOfUserBasicData;
	int users;
	
	public UserBasicDAOImpl() {
		super();
		this.listOfUserBasicData = new ArrayList<>();
		users = 0;
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
	
	private User getListIdByUserId(int userId) throws NoUserIdInDataBase{
		User user = listOfUserBasicData.stream().filter(x->x.getUserId()==userId).findFirst().get();
		if(user!=null){
			return user;
		}else{
		throw new NoUserIdInDataBase();
		}
	}


}












