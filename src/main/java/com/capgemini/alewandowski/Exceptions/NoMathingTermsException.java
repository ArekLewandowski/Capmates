package com.capgemini.alewandowski.Exceptions;

public class NoMathingTermsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoMathingTermsException() {

	}
	
	public  NoMathingTermsException(String message) {
		super("Invalid data " + message);
	}

}
