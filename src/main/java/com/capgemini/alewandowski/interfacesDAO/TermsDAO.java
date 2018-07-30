package com.capgemini.alewandowski.interfacesDAO;

import java.util.List;

import com.capgemini.alewandowski.entities.UserAvailability;

public interface TermsDAO {
	
	void addTerm(UserAvailability userAvaibility);
	UserAvailability editTerm(UserAvailability termToEdit, UserAvailability termAfterEdit);
	UserAvailability deleteTerm(UserAvailability deletedTerm, String comment);
	List<UserAvailability> getUserTerms(int userId);
	List<UserAvailability> getSameTerm(UserAvailability term);
}
 