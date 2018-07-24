package com.capgemini.alewandowski.entities;

import com.capgemini.alewandowski.ENUMS.LEVEL;

public class PlayerGameStats {
	private Game game;
	private boolean owner;
	private int currentLevelPoints;
	private LEVEL currentLevel;
	private int won;
	private int lost;
	private int draw;
	//Constructor
	public PlayerGameStats(Game game, boolean owner) {
		super();
		this.game = game;
		this.owner = owner;
	}
	
	
	//Getters and setters
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public int getCurrentLevelPoints() {
		return currentLevelPoints;
	}
	public void setCurrentLevelPoints(int currentLevelPoints) {
		this.currentLevelPoints = currentLevelPoints;
	}
	public LEVEL getCurrentLevel() {
		return currentLevel;
	}
	public void setCurrentLevel(LEVEL currentLevel) {
		this.currentLevel = currentLevel;
	}
	public int getWon() {
		return won;
	}
	public void setWon(int won) {
		this.won = won;
	}
	public int getLost() {
		return lost;
	}
	public void setLost(int lost) {
		this.lost = lost;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
	}


	public boolean isOwner() {
		return owner;
	}


	public void setOwner(boolean owner) {
		this.owner = owner;
	}

	
}
