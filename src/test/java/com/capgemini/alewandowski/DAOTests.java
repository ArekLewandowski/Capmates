package com.capgemini.alewandowski;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.capgemini.alewandowski.ENUMS.DIFFICULTY;
import com.capgemini.alewandowski.ENUMS.GAME_TYPE;
import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.entities.GameResult;
import com.capgemini.alewandowski.entities.User;
import com.capgemini.alewandowski.entities.UserStats;
import com.capgemini.alewandowski.interfacesDAO.GamesDAO;
import com.capgemini.alewandowski.interfacesDAO.GamesHistoryDAO;
import com.capgemini.alewandowski.interfacesDAO.UserBasicDAO;
import com.capgemini.alewandowski.interfacesDAO.UserStatsDAO;
import com.capgemini.alewandowski.repositories.GamesDAOImpl;
import com.capgemini.alewandowski.repositories.GamesHistoryDAOImpl;
import com.capgemini.alewandowski.repositories.UserBasicDAOImpl;
import com.capgemini.alewandowski.repositories.UserStatsDAOImpl;



public class DAOTests {

	@Test
	public void shouldAddGameToList(){
		//given
		GamesDAO gamesDAO = new GamesDAOImpl();
		gamesDAO.addToList(new Game("Monopoly", true));
		gamesDAO.addToList(new Game("Stratego", 3, 3, true, DIFFICULTY.MEDIUM, 60, GAME_TYPE.STRATEGY));
		//when
		List<String> list = gamesDAO.getListOfGames();
//		System.out.println(list.toString());
		//then
		assertEquals(2, list.size());
	}
	@Test
	public void shouldRemoveGameFromList(){
		//given
		GamesDAO gamesDAO = new GamesDAOImpl();
		gamesDAO.addToList(new Game("Monopoly", true));
		gamesDAO.addToList(new Game("Stratego", 3, 3, true, DIFFICULTY.MEDIUM, 60, GAME_TYPE.STRATEGY));
		//when
		gamesDAO.delete(0);
		List<String> list = gamesDAO.getListOfGames();
		System.out.println(list.toString());
		//then
		assertEquals(1, list.size());
	}
	@Test
	public void shouldEditGameInList(){
		//given
		GamesDAO gamesDAO = new GamesDAOImpl();
		gamesDAO.addToList(new Game("Monopoly", true));
		gamesDAO.addToList(new Game("Stratego", 3, 3, true, DIFFICULTY.MEDIUM, 60, GAME_TYPE.STRATEGY));
		//when
		gamesDAO.editGame(0, new Game("Monopoly", 2, 6, true, DIFFICULTY.EXTREME, 120, GAME_TYPE.CLASSIC));
		Game game = gamesDAO.getByIndex(0);
		System.out.println(game.getGameId());
		System.out.println(game.getTitle());
		System.out.println(game.getMinPlayers());
		System.out.println(game.getMaxPlayers());
		System.out.println(game.getMinRecuiredForOnePlay());
		System.out.println(game.getDifficultLevel());
		System.out.println(game.getType());
		//then
		assertEquals(DIFFICULTY.EXTREME, game.getDifficultLevel());
	}
	//GamesHistoryTests
	@Test
	public void shouldAddRacordToHistory(){
		//given
		UserBasicDAO ubd = new UserBasicDAOImpl();
		ubd.addUser(new User("Ala", "Kot"));
		ubd.addUser(new User("Jan", "Ko"));
		ubd.addUser(new User("John", "Doe"));
		ubd.addUser(new User("Ed", "Bo"));
		
		List<Integer> players = new ArrayList<>();
		players.add(0);
		players.add(1);
		List<Integer> players1 = new ArrayList<>();
		players1.add(0);
		players1.add(2);
		GamesHistoryDAO gHistoryDAO = new GamesHistoryDAOImpl();
		//when
		gHistoryDAO.addRecord(new GameResult(new Game("Carts", true), players, 0));
		gHistoryDAO.addRecord(new GameResult(new Game("Carts", true), players1, 2));
		List<GameResult> allhistory =  gHistoryDAO.getHistory();
//		for (GameResult gameResult : allhistory) {
//			System.out.println(gameResult.getPlayedGame().getTitle());
//			System.out.println(gameResult.getUserWon());
//		}
		//then
		assertArrayEquals(2, allhistory.size());
	}
	private void assertArrayEquals(int i, int size) {
		// TODO Auto-generated method stub
		
	}
	@Test
	public void shouldReturnisEmptyFalse(){
		//given
		List<Integer> players = new ArrayList<>();
		players.add(0);
		players.add(1);
		GamesHistoryDAO gHistoryDAO = new GamesHistoryDAOImpl();
		gHistoryDAO.addRecord(new GameResult(new Game("Carts", true), players, 0));
		List<Integer> players1 = new ArrayList<>();
		players1.add(0);
		players1.add(2);
		gHistoryDAO.addRecord(new GameResult(new Game("Carts", true), players1, 2));
		//when
		List<GameResult> allhistory =  gHistoryDAO.getHistory();
		for (GameResult gameResult : allhistory) {
			System.out.println(gameResult.getPlayedGame().getTitle());
			System.out.println(gameResult.getUserWon());
		}
		//then
		assertFalse(allhistory.isEmpty());
	}
	@Test
	public void shouldShowUsersRecord(){
		//given
		List<Integer> players = new ArrayList<>();
		players.add(0);
		players.add(1);
		GamesHistoryDAO gHistoryDAO = new GamesHistoryDAOImpl();
		gHistoryDAO.addRecord(new GameResult(new Game("Carts", true), players, 0));
		List<Integer> players1 = new ArrayList<>();
		players1.add(0);
		players1.add(2);
		gHistoryDAO.addRecord(new GameResult(new Game("Carts", true), players1, 2));
		//when
		List<GameResult> userHistory =  gHistoryDAO.getRecordByUser(0);
		//then
		assertEquals(2, userHistory.size());
	}
	@Test
	public void shouldShowGamesRecord(){
		//given
		GamesDAO gamesDAO = new GamesDAOImpl();
		gamesDAO.addToList(new Game("Carts", true));
		gamesDAO.addToList(new Game("Monopoly", true));
		
		List<Integer> players = new ArrayList<>();
		players.add(0);
		players.add(1);
		GamesHistoryDAO gHistoryDAO = new GamesHistoryDAOImpl();
		gHistoryDAO.addRecord(new GameResult(gamesDAO.getByIndex(0), players, 0));
		List<Integer> players2 = new ArrayList<>();
		players2.add(2);
		players2.add(1);
		gHistoryDAO.addRecord(new GameResult(gamesDAO.getByIndex(1), players, 0));
		List<Integer> players1 = new ArrayList<>();
		players1.add(1);
		players1.add(2);
		gHistoryDAO.addRecord(new GameResult(gamesDAO.getByIndex(0), players1, 2));
		//when
		List<GameResult> gameHistory =  gHistoryDAO.getRecordByGame(0);
		//then
		assertEquals(2, gameHistory.size());
	}
	//UserStatsTest
	@Test
	public void shouldAddPionts(){
		UserStatsDAO userStatsDAO = new UserStatsDAOImpl();
		userStatsDAO.addNewUserStats(new UserStats());
	}

}
