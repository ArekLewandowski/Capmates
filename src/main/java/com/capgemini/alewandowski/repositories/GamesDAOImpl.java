package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.entities.Game;
import com.capgemini.alewandowski.interfaces.GamesDAO;

@Repository
public class GamesDAOImpl implements GamesDAO{
	
	List<Game> listOfGames;
	
	public GamesDAOImpl() {
		super();
		this.listOfGames = new ArrayList<>();
	}

	@Override
	public void addToList(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Game delete(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game delete(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Game> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game getByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Game edit(Game item) {
		// TODO Auto-generated method stub
		return null;
	}

}
