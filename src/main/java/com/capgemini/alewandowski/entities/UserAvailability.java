package com.capgemini.alewandowski.entities;

public class UserAvailability {
	int userId;
	String term;
	boolean isActual;
	String comment;
	public UserAvailability(int userId, String term) {
		super();
		this.userId = userId;
		this.term = term;
		this.isActual = true;		
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId){
		this.userId = userId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public boolean isActual() {
		return isActual;
	}
	public void setActual(boolean isActual) {
		this.isActual = isActual;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}


	
	

}
