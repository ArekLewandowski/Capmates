package com.capgemini.alewandowski.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.alewandowski.entities.Challange;
import com.capgemini.alewandowski.entities.UserAvailability;
import com.capgemini.alewandowski.interfaces.AvaiabilityService;
import com.capgemini.alewandowski.interfacesDAO.TermsDAO;


@Service
public class AvaibilityServiceImpl implements AvaiabilityService{

	@Autowired
	TermsDAO termsDAO;
	

	@Override
	public UserAvailability addNewTerm(UserAvailability newTerm) {
		termsDAO.addTerm(newTerm);
		return newTerm;
	}

	@Override
	public UserAvailability editTerm(UserAvailability changedTerm, UserAvailability newTerm) {
		termsDAO.editTerm(changedTerm, newTerm);
		return newTerm;
	}

	@Override
	public UserAvailability removeTerm(UserAvailability deletedTerm, String comment) {
		termsDAO.deleteTerm(deletedTerm, comment);
		return deletedTerm;
	}

	@Override
	public List<UserAvailability> getUserTerms(int userId) {
		termsDAO.getUserTerms(userId);
		return null;
	}
	
	@Override
	public Challange checkPartnerAvaibility(UserAvailability userTerm) {
		UserAvailability userCheckedTerm = userTerm;
		String term = userCheckedTerm.getTerm();
		List<UserAvailability> oponentsTerms = termsDAO.getSameTerm(userTerm);
		int playerId = userCheckedTerm.getUserId();
		List<Integer> oponents = new ArrayList<>(); 
		for (UserAvailability userAvailability : oponentsTerms) {
			oponents.add((Integer)userAvailability.getUserId());
		}
		Challange createdChallange = new Challange(oponents, playerId, term);
		
		return createdChallange;
	}
}
