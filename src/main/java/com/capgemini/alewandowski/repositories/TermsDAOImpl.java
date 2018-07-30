package com.capgemini.alewandowski.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.alewandowski.entities.UserAvailability;
import com.capgemini.alewandowski.interfacesDAO.TermsDAO;

@Repository
public class TermsDAOImpl implements TermsDAO{
	List<UserAvailability> listOfTerms;

	public TermsDAOImpl() {
		super();
		listOfTerms = new ArrayList<>();
	}

	@Override
	public void addTerm(UserAvailability userAvaibility) {
		listOfTerms.add(userAvaibility);
	}

	@Override
	public UserAvailability editTerm(UserAvailability termToEdit, UserAvailability termAfterEdit) {
		int index = listOfTerms.indexOf(termToEdit);
		UserAvailability uAvaibility = listOfTerms.get(index);
		listOfTerms.set(index, termAfterEdit);
		return uAvaibility;
	}

	@Override
	public UserAvailability deleteTerm(UserAvailability deletedTerm, String comment) {
		int index = listOfTerms.indexOf(deletedTerm);
		UserAvailability delAvaibility = listOfTerms.get(index);
		delAvaibility.setActual(false);
		delAvaibility.setComment(comment);
		listOfTerms.set(index, delAvaibility);
		return delAvaibility;
	}

	@Override
	public List<UserAvailability> getUserTerms(int userId) {
		List<UserAvailability> userTerms = new ArrayList<>();
		for (UserAvailability userAvaibility : userTerms) {
			if(userAvaibility.getUserId()==userId){
				userTerms.add(userAvaibility);
			}
		}
		return userTerms;
	}

	@Override
	public List<UserAvailability> getSameTerm(UserAvailability term) {
		List<UserAvailability> matchingTerms = new ArrayList<>();
		int index = listOfTerms.indexOf(term);
		String checkedTerm = listOfTerms.get(index).getTerm();
		int checkedUserId = listOfTerms.get(index).getUserId();
		for (UserAvailability userAvaibility : listOfTerms) {
			if (userAvaibility.getTerm().equals(checkedTerm) && 
					userAvaibility.isActual()==true &&
					userAvaibility.getUserId()!=checkedUserId) {
				matchingTerms.add(userAvaibility);
			}
		}
		return matchingTerms;
	}
	
	
}
