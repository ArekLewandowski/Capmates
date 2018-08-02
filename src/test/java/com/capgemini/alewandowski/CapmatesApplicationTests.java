package com.capgemini.alewandowski;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.services.UserDataServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CapmatesApplicationTests {
	@Autowired
	UserDataServiceImpl userDataServiceImpl;

	@Test
	public void contextLoads() {
		
		
		//given
//		UserBasicDAO ubd = new UserBasicDAOImpl();
		userDataServiceImpl.addNewUser(new User("Ala", "Kot"));
//		ubd.addUser(new User("Jan", "Ko"));
//		ubd.addUser(new User("John", "Doe"));
//		ubd.addUser(new User("Ed", "Bo"));
//		ubd.editUser(0, new User("Arek", "Le"));
//		ubd.deleteUser(1);
//		User user = ubd.getUser(2);
//		System.out.println(user.getFirstName());
		
	
	}

}
