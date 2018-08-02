package com.capgemini.alewandowski.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason="No such User")  // 404
public class NoUserIdInDataBase extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4280865370257900317L;

	public NoUserIdInDataBase() {

	}
	
	public  NoUserIdInDataBase(String message) {
		super("Invalid data " + message);
	}

}
