package com.capgemini.alewandowski.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.capgemini.alewandowski.Exceptions.EmptyListException;
import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;

@ControllerAdvice
public class ExceptionHandlingController {

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Empty list exception") // 404
	@ExceptionHandler(EmptyListException.class)
	public void empty() {

	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Empty list exception") // 404
	@ExceptionHandler(NoUserIdInDataBase.class)
	public void noUser() {

	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Empty list exception") // 404
	@ExceptionHandler(NoSuchElementException.class)
	public void noElement() {
	}

}
