package com.capgemini.alewandowski;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.controllers.Controller;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.interfaces.UserDataService;
import com.capgemini.alewandowski.services.UserDataServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTests {
	
	@Autowired
	private Controller controller;
	
	@Mock 
	private UserDataService uDataService;
	

	@Before
	public void setup(){
		List<User> users = new ArrayList<>();
				users.add(new User("Arek", "Le"));
				users.add(new User("Arek1", "Le1"));
				users.add(new User("Arek2", "Le2"));
				users.add(new User("Arek3", "Le3"));
				users.add(new User("Arek4", "Le4"));
		Mockito.when(uDataService.getUsers()).thenReturn(users);
	}
	@Test
	public void shouldShowUsers() throws NoUserIdInDataBase{
			
		//given
		List<User> newlist = controller.getUsersData();
		
		//when
		String name = newlist.get(0).getFirstName();
		
		//then
		assertEquals("Arek", name);
	}
}