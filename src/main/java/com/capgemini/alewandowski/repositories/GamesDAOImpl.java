package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.interfacesDAO.GamesDAO;

@Repository
public class GamesDAOImpl implements GamesDAO{	
	List<Game> listOfGames;
	private int games;
	public GamesDAOImpl() {
		super();
		this.listOfGames = new ArrayList<>();
		games = 0;
	}

	@Override
	public void addToList(Game game) {
		Game addGame = game;
		addGame.setGameId(games);
		listOfGames.add(game);
		games++;
	}

	@Override
	public void delete(int index) {
		listOfGames.remove(index);
	}

	@Override
	public List<Game> getAll() {
		return listOfGames;
	}
	@Override
	public List<String> getListOfGames() {
		List<String> listOfGameNames = new ArrayList<>();
		for(int i = 0; i<listOfGames.size(); i++){
			listOfGameNames.add(listOfGames.get(i).getTitle());
		}
		return listOfGameNames;
	}

	@Override
	public Game getByIndex(int index) {
		return listOfGames.get(index);
	}

	@Override
	public void editGame(int gameId, Game editedGame) {
		listOfGames.set(gameId, editedGame);
	}


}
