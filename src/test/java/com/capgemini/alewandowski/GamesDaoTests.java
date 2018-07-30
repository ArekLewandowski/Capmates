package com.capgemini.alewandowski;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.capgemini.alewandowski.entities.UserGame;
import com.capgemini.alewandowski.interfacesDAO.UserGamesDAO;
import com.capgemini.alewandowski.repositories.UserGamesDAOImpl;

public class GamesDaoTests {
	
	@Test
	
	public void shouldAddGametoUserList(){
		//given
		UserGamesDAO userGamesDAO =new UserGamesDAOImpl();
		userGamesDAO.addGameToUser(0, 0);
		userGamesDAO.addGameToUser(1, 0);
		userGamesDAO.addGameToUser(2, 0);
		userGamesDAO.addGameToUser(1, 1);
		userGamesDAO.addGameToUser(1, 2);
		userGamesDAO.addGameToUser(3, 1);
		//when
		 List<Integer> records = userGamesDAO.getGamesByUserId(1);
		 
		//then
		assertEquals(3, records.size());
	}

	@Test
	
	public void shouldRemoveGamefromUserList(){
		//given
		UserGamesDAO userGamesDAO =new UserGamesDAOImpl();
		userGamesDAO.addGameToUser(0, 0);
		userGamesDAO.addGameToUser(1, 0);
		userGamesDAO.addGameToUser(2, 0);
		userGamesDAO.addGameToUser(1, 1);
		userGamesDAO.addGameToUser(1, 2);
		userGamesDAO.addGameToUser(3, 1);
		//when
		userGamesDAO.removeGameFromUser(new UserGame(1, 1));
		List<Integer> records = userGamesDAO.getGamesByUserId(1);
		 
		//then
		assertEquals(2, records.size());
	}
}
