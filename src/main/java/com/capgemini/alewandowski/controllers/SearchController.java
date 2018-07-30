package com.capgemini.alewandowski.controllers;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.interfaces.UserDataService;

@RestController
public class SearchController {

	@Autowired
	private UserDataService uDataService;
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public List<User> queryStringMapping(
            @RequestParam(required = false) String firstName, 
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email) throws NoUserIdInDataBase {
		Map<String, String> filters = new TreeMap<>();
		filters.put("firstName", firstName);
		filters.put("lastName", lastName);
		filters.put("email", email);
		List<User> searchedUsers = uDataService.searchUsers(filters.get("firstName"), filters.get("lastName"), filters.get("email"));
        return searchedUsers;       
	}

}
