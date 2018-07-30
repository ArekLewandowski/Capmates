package com.capgemini.alewandowski.interfaces;

import java.util.List;

import com.capgemini.alewandowski.entities.Challange;
import com.capgemini.alewandowski.entities.UserAvailability;

public interface AvaiabilityService {
	UserAvailability addNewTerm(UserAvailability newTerm);
	UserAvailability editTerm(UserAvailability changedTerm, UserAvailability newTerm);
	UserAvailability removeTerm(UserAvailability deletedTerm, String comment);
	List<UserAvailability> getUserTerms(int userId);
	Challange checkPartnerAvaibility(UserAvailability userTerm);
}
