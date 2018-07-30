package com.capgemini.alewandowski.Exceptions;

public class NoGameIdInDataBaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoGameIdInDataBaseException() {

	}
	
	public  NoGameIdInDataBaseException(String message) {
		super("Invalid data " + message);
	}

}

