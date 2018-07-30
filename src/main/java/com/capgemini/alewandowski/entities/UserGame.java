package com.capgemini.alewandowski.entities;

public class UserGame {
	int userId;
	int gameId;
	public UserGame(int userId, int gameId) {
		super();
		this.userId = userId;
		this.gameId = gameId;
	}
	public int getUserId() {
		return userId;
	}

	public int getGameId() {
		return gameId;
	}
	
}
