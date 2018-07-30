package com.capgemini.alewandowski.Exceptions;

public class InvalidDataException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1965547164449291218L;

	public InvalidDataException() {

	}
	
	public InvalidDataException(String message) {
		super("Invalid data " + message);
	}

}

