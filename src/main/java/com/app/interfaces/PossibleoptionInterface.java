package com.app.interfaces;

import java.util.List;

import com.app.model.Possibleoption;

public interface PossibleoptionInterface {

	List<Possibleoption> getAllPossibleoption();
	
	Possibleoption getPossibleoptionById(Integer possibleOptionId);
	int savePossibleOption (Possibleoption possibleoption);
	boolean deletePossibleOption(Integer possibleoption);
	boolean updatePossibleOption(Possibleoption possibleoption);
}
