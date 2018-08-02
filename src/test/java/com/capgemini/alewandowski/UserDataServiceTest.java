package com.capgemini.alewandowski;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.interfaces.UserDataService;
import com.capgemini.alewandowski.interfacesDAO.UserBasicDAO;
import com.capgemini.alewandowski.interfacesDAO.UserStatsDAO;
import com.capgemini.alewandowski.services.UserDataServiceImpl;

@RunWith(MockitoJUnitRunner.class) 
public class UserDataServiceTest {
	
	@Mock 
	private UserBasicDAO uBasicDao; 
	
	@Mock 
	private UserStatsDAO uStatsDao; 

	@Before
	public void setup(){
		User user = new User("Arek", "Le");
		Mockito.when(uBasicDao.addUser(user)).thenReturn(user);
	}
	@Test
	public void shouldAddNewUser() throws NoUserIdInDataBase{
			
		//given
		UserDataService userDataService = new UserDataServiceImpl();
		userDataService.addNewUser(new User("Arek", "L"));
		userDataService.addNewUser(new User("Piotr", "La"));
		userDataService.addNewUser(new User("John", "Lwe"));
		userDataService.addNewUser(new User("Bob", "Ler"));
		userDataService.addNewUser(new User("Ed", "Let"));
		//when
		userDataService.viewInforamtion(1);
		
	}
}


