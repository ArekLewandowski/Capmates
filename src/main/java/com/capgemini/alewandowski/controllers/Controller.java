package com.capgemini.alewandowski.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.interfaces.UserDataService;

@RestController
@RequestMapping("/users")
public class Controller {
	
	@Autowired
	private UserDataService uDataService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<User> getUsersData(){
		return uDataService.getUsers();
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public User getUsersData(@PathVariable("id") int id) throws NoUserIdInDataBase{
		return uDataService.viewInforamtion(id);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public User deleteUsersData(@PathVariable("id") int id) throws NoUserIdInDataBase{
		return uDataService.deleteUser(id);
	}
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	private User addNewUser(@RequestBody User user){
		uDataService.addNewUser(user);
		return user;
	}
}