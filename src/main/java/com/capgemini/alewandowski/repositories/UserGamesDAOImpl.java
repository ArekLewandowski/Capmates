package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.entities.UserGame;
import com.capgemini.alewandowski.interfacesDAO.UserGamesDAO;

@Repository
public class UserGamesDAOImpl implements UserGamesDAO{
	List<UserGame> listOfUsersGames;

	public UserGamesDAOImpl() {
		super();
		listOfUsersGames = new ArrayList<>();
	}
	@Override
	public void addGameToUser(int userId, int gameId) {
	listOfUsersGames.add(new UserGame(userId, gameId));
}

	@Override
	public void removeGameFromUser(UserGame userGame) {
		for (UserGame uGame : listOfUsersGames) {
			if (uGame.getUserId()==userGame.getUserId() &&
					uGame.getGameId()==userGame.getGameId()) {
				int id = listOfUsersGames.indexOf(uGame);
				listOfUsersGames.remove(id);
				break;
			}
		}
	
	}
	@Override
	public List<Integer> getGamesByUserId(int userId) {
		List<Integer> usersGameList = new ArrayList<>();
		for (UserGame userGame : listOfUsersGames) {
			if (userGame.getUserId()==userId) {
				usersGameList.add(userGame.getGameId());
			}
		}
		return usersGameList;
		
	}

}
