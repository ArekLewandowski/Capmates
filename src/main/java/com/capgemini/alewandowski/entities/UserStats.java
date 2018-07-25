package com.capgemini.alewandowski.entities;

public class UserStats {
	private int UserId;
	private int currentLevelPoints;
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
