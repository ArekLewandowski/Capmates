package com.capgemini.alewandowski.interfacesDAO;

import java.util.List;

import com.capgemini.alewandowski.entities.UserGame;

public interface UserGamesDAO {
	void addGameToUser(int userId, int gameId);
	List<Integer> getGamesByUserId(int userId);
	void removeGameFromUser(UserGame userGame);
	}
