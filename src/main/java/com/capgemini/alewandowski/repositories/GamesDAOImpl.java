package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.interfacesDAO.GamesDAO;

@Repository
public class GamesDAOImpl implements GamesDAO{	
	List<Game> listOfGames;
	
	public GamesDAOImpl() {
		super();
		this.listOfGames = new ArrayList<>();
	}

	@Override
	public void addToList(Game game) {
		listOfGames.add(game);
		
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
