package com.capgemini.alewandowski.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.ENUMS.DIFFICULTY;
import com.capgemini.alewandowski.ENUMS.GAME_TYPE;
import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.interfaces.GamesDataService;
import com.capgemini.alewandowski.repositories.GamesDAOImpl;
import com.capgemini.alewandowski.repositories.UserBasicDAOImpl;

@Service
public class GamesDataServiceImpl implements GamesDataService {
	private int games;

	@Autowired
	GamesDAOImpl gamesDAOImpl;

	@Autowired
	UserBasicDAOImpl userBasicDAOImpl;

	public GamesDataServiceImpl() {
		super();
		games = 0;
	}

	@Override
	public Game createGame(String title, boolean isOnePlayable) {
		Game game = new Game(title, isOnePlayable);
		game.setGameId(games);
		gamesDAOImpl.addToList(game);
		games++;
		return game;
	}

	@Override
	public Game createGame(int gameId, String title, int minPlayers, int maxPlayers, boolean isOnePlayable,
			DIFFICULTY difficultLevel, int minRecuiedForOnePlay, GAME_TYPE type) {
		Game game = new Game(title, minPlayers, maxPlayers, isOnePlayable, difficultLevel, minRecuiedForOnePlay, type);
		game.setGameId(games);
		gamesDAOImpl.addToList(game);
		games++;
		return game;
	}

	@Override
	public void addGame(int userId, int gameId) {
		userBasicDAOImpl.getUser(userId).getListOfGames().add(gameId);
	}

	@Override
	public void editGameTitle(int gameId, String newTitle) {
		Game editedGame = gamesDAOImpl.getByIndex(gameId);
		editedGame.setTitle(newTitle);
		gamesDAOImpl.editGame(gameId, editedGame);
	}

	@Override
	public void editGameMinPlayers(int gameId, int minPlayers) {
		Game editedGame = gamesDAOImpl.getByIndex(gameId);
		editedGame.setMinPlayers(minPlayers);
		gamesDAOImpl.editGame(gameId, editedGame);
	}

	@Override
	public void editGameMaxPlayers(int gameId, int maxPlayers) {
		Game editedGame = gamesDAOImpl.getByIndex(gameId);
		editedGame.setMaxPlayers(maxPlayers);
		gamesDAOImpl.editGame(gameId, editedGame);
	}

	@Override
	public void editGameIsOnePlay(int gameId, boolean isOne) {
		Game editedGame = gamesDAOImpl.getByIndex(gameId);
		editedGame.setOnePlayable(isOne);
		gamesDAOImpl.editGame(gameId, editedGame);
	}

	@Override
	public void editGameDifficulty(int gameId, DIFFICULTY difficulty) {
		Game editedGame = gamesDAOImpl.getByIndex(gameId);
		editedGame.setDifficultLevel(difficulty);
		gamesDAOImpl.editGame(gameId, editedGame);
	}

	@Override
	public void editGameTime(int gameId, int min) {
		Game editedGame = gamesDAOImpl.getByIndex(gameId);
		editedGame.setMinRecuiredForOnePlay(min);
		gamesDAOImpl.editGame(gameId, editedGame);
	}

	@Override
	public void editGameType(int gameId, GAME_TYPE type) {
		Game editedGame = gamesDAOImpl.getByIndex(gameId);
		editedGame.setType(type);
		gamesDAOImpl.editGame(gameId, editedGame);
	}

	@Override
	public void showDetails(int gameId) {
		Game editedGame = gamesDAOImpl.getByIndex(gameId);
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

		List<String> listOfGameNames = gamesDAOImpl.getListOfGames();
		for (String title : listOfGameNames) {
			System.out.println(title);
		}
		return listOfGameNames;
	}

}
