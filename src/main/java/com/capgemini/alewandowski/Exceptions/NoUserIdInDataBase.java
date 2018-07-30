package com.capgemini.alewandowski.Exceptions;

public class NoUserIdInDataBase extends Exception{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoUserIdInDataBase() {

	}
	
	public  NoUserIdInDataBase(String message) {
		super("Invalid data " + message);
	}

}
