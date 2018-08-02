package com.capgemini.alewandowski;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import com.capgemini.alewandowski.Exceptions.NoUserIdInDataBase;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.interfacesDAO.UserBasicDAO;
import com.capgemini.alewandowski.repositories.UserBasicDAOImpl;



public class UserBasicDAOTest {
	@Test
	public void shouldAddUserToList(){
		//given
		UserBasicDAO userBasicDAO = new UserBasicDAOImpl();
		
		//when
		
		userBasicDAO.deleteUser(1);
		//then
		assertEquals(4, userBasicDAO.getRankingData().size());
	}
		@Test
		public void shouldRemoveUserFromList(){
			//given
			UserBasicDAO userBasicDAO = new UserBasicDAOImpl();
			
			//when

			userBasicDAO.editUser(0, new User("Arek", "Le"));
			userBasicDAO.deleteUser(1);
			//then
			assertEquals(4, userBasicDAO.getRankingData().size());
		}
		@Test
		public void shouldEditUserFromList() throws NoUserIdInDataBase{
			//given
			UserBasicDAO userBasicDAO = new UserBasicDAOImpl();
			
			//when
			userBasicDAO.addUser(new User("Tom","No"));
			userBasicDAO.addUser(new User("Jan", "Ko"));
			userBasicDAO.addUser(new User("John", "Doe"));
			userBasicDAO.addUser(new User("Ed", "Bo"));
			userBasicDAO.editUser(0, new User("Arek", "Le"));
//			userBasicDAO.deleteUser(0);
			User user;
			for(int i = 0; i < userBasicDAO.getRankingData().size(); i++){
				user = userBasicDAO.getUserByListId(i);
				System.out.println(user.getFirstName());
			}
			//then
			assertEquals("Arek", userBasicDAO.getRankingData().get(0).getFirstName());
		}
}
