package com.capgemini.alewandowski.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.ENUMS.DIFFICULTY;
import com.capgemini.alewandowski.ENUMS.GAME_TYPE;
import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.interfaces.GamesDataService;
import com.capgemini.alewandowski.interfacesDAO.GamesDAO;
import com.capgemini.alewandowski.interfacesDAO.UserBasicDAO;
import com.capgemini.alewandowski.interfacesDAO.UserGamesDAO;

@Service
public class GamesDataServiceImpl implements GamesDataService {

	@Autowired
	private GamesDAO gamesDAO;

	@Autowired
	private UserBasicDAO userBasicDAO;
	
	@Autowired
	private UserGamesDAO userGamesDAO;

	public GamesDataServiceImpl() {
		super();
	}

	@Override
	public Game createGame(String title, boolean isOnePlayable) {
		Game game = new Game(title, isOnePlayable);
		gamesDAO.addToList(game);
		return game;
	}

	@Override
	public Game createGame(int gameId, String title, int minPlayers, int maxPlayers, boolean isOnePlayable,
			DIFFICULTY difficultLevel, int minRecuiedForOnePlay, GAME_TYPE type) {
		Game game = new Game(title, minPlayers, maxPlayers, isOnePlayable, difficultLevel, minRecuiedForOnePlay, type);
		gamesDAO.addToList(game);
		return game;
	}

	@Override
	public void addGame(int userId, int gameId) {
		userGamesDAO.addGameToUser(userId, gameId);
	}

	@Override
	public void showDetails(int gameId) {
		Game editedGame = gamesDAO.getByIndex(gameId);
		System.out.println("Id: " + editedGame.getGameId());
		System.out.println("Title: " + editedGame.getTitle());
		System.out.println("Type: " + editedGame.getType());
		System.out.println("Difficulty: " + editedGame.getDifficultLevel());
		System.out.println("Min players: " + editedGame.getMinPlayers());
		System.out.println("Max players: " + editedGame.getMaxPlayers());
		System.out.println("Time: " + editedGame.getMinRecuiredForOnePlay());
	}

	@Override
	public List<String> getListOfGames() {

		List<String> listOfGameNames = gamesDAO.getListOfGames();
		for (String title : listOfGameNames) {
			System.out.println(title);
		}
		return listOfGameNames;
	}

	@Override
	public void editGame(int gameId, Game editedGame) {
		gamesDAO.editGame(gameId, editedGame);
		
	}

}
