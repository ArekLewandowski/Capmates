package com.capgemini.alewandowski.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.entities.RankingEntity;
import com.capgemini.alewandowski.interfacesDAO.UserBasicDAO;
import com.capgemini.alewandowski.interfacesDAO.UserStatsDAO;

@Service
public class RankingServiceImpl {
	List<RankingEntity> ranking;
	
	@Autowired
	private UserStatsDAO userStatsDAO;
	
	@Autowired
	private UserBasicDAO userBasicDAO;

	public List<RankingEntity> createRanking() {
		ranking = new ArrayList<>();
		List<RankingEntity> basicTO = userBasicDAO.getRankingData();
		List<RankingEntity> statsTO = userStatsDAO.getRankingData();
		
		for (RankingEntity rankingEntity : statsTO) {
			ranking.add(rankingEntity);
		}
		for (RankingEntity rankingEntity : ranking) {
			int userId = rankingEntity.getUserId();
			rankingEntity.setFirstName(basicTO.get(userId).getFirstName());
			rankingEntity.setLastName(basicTO.get(userId).getLastName());

		}
		Stream<RankingEntity> stream = ranking.stream();
		List<RankingEntity> rankingSortedList = stream.sorted((u1, u2)->Integer.compare(u1.getPoints(), u2.getPoints())).collect(Collectors.toList());
		return rankingSortedList;
		
	}
	
	
}
