package com.capgemini.alewandowski.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.ENUMS.LEVEL;
import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.entities.User;

@Service
public interface UserDataService {
	User addNewUser(String firstName, String lastName);
	
	User changeUserData(int userId);
	
	User deleteUser();
	
	User vievInforamtion(int userId);
	

}
