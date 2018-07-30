package com.capgemini.alewandowski.entities;

import java.util.List;

public class Challange {
	List<Integer> oponents;
	int playerId;
	String term;
	public Challange(List<Integer> oponents, int playerId, String term) {
		super();
		this.oponents = oponents;
		this.playerId = playerId;
		this.term = term;
	}
	public List<Integer> getOponents() {
		return oponents;
	}
	public void setOponents(List<Integer> oponents) {
		this.oponents = oponents;
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}

	
	
}
