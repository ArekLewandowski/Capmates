package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.entities.Game;

public interface GamesDAO {
	
	void addToList(Game game);
	Game delete(int index);
	Game delete(String name);
	
	List<Game> getAll();
	Game getByIndex(int index);
	Game getByName(String name);
	
	Game edit(Game item);

}
