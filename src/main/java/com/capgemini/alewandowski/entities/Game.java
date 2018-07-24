package com.capgemini.alewandowski.entities;


import com.capgemini.alewandowski.ENUMS.DIFFICULTY;
import com.capgemini.alewandowski.ENUMS.GAME_TYPE;

public class Game{
	private int gameId;
	private String title;
	private int minPlayers;
	private int maxPlayers;
	private boolean isOnePlayable;
	private DIFFICULTY difficultLevel;
	private int minRecuiredForOnePlay;
	private GAME_TYPE type;
	




	//Constructors
	public Game(String title, boolean isOnePlayable) {
		super();
		this.title = title.toUpperCase();
		this.isOnePlayable = isOnePlayable;
	}
	
	
	
	
	public Game(String title, int minPlayers, int maxPlayers, boolean isOnePlayable,
			DIFFICULTY difficultLevel, int minRecuiedForOnePlay, GAME_TYPE gameType) {
		super();
		this.title = title.toUpperCase();
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.isOnePlayable = isOnePlayable;
		this.difficultLevel = difficultLevel;
		this.minRecuiredForOnePlay = minRecuiedForOnePlay;
		this.type = gameType;
	}
	//Getters and Setters
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title.toUpperCase();
	}
	public int getMinPlayers() {
		return minPlayers;
	}
	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}
	public int getMaxPlayers() {
		return maxPlayers;
	}
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	public boolean isOnePlayable() {
		return isOnePlayable;
	}
	public void setOnePlayable(boolean isOnePlayable) {
		this.isOnePlayable = isOnePlayable;
	}
	public DIFFICULTY getDifficultLevel() {
		return difficultLevel;
	}
	public void setDifficultLevel(DIFFICULTY difficultLevel) {
		this.difficultLevel = difficultLevel;
	}
	public int getMinRecuiredForOnePlay() {
		return minRecuiredForOnePlay;
	}	
	public void setMinRecuiredForOnePlay(int minRecuiredForOnePlay) {
		this.minRecuiredForOnePlay = minRecuiredForOnePlay;
	}	
	public GAME_TYPE getType() {
		return type;
	}	
	public void setType(GAME_TYPE type) {
		this.type = type;
	}	
}
