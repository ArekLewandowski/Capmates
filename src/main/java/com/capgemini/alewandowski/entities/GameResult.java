package com.capgemini.alewandowski.entities;

import java.util.List;

public class GameResult {
	Game playedGame;
	List<Integer> playedUsersId;
	int userWon;
	
	public GameResult(Game playedGame, List<Integer> playedUsersId, int userWon) {
		super();
		this.playedGame = playedGame;
		this.playedUsersId = playedUsersId;
		this.userWon = userWon;
	}

	public Game getPlayedGame() {
		return playedGame;
	}

	public List<Integer> getPlayedUsersId() {
		return playedUsersId;
	}

	public int getUserWon() {
		return userWon;
	}
	
}
