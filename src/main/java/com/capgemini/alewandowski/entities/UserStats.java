package com.capgemini.alewandowski.entities;

import com.capgemini.alewandowski.ENUMS.LEVEL;

public class UserStats {
	private int UserId;
	private int currentLevelPoints;
	private LEVEL currentLevel;
	private int won;
	private int lost;
	private int draw;
	//Constructor
	public UserStats() {
		super();
	}
	//Getters and setters
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
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
}
