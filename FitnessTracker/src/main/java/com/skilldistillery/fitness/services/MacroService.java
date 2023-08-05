package com.skilldistillery.fitness.services;

import java.util.List;

import com.skilldistillery.fitness.entities.Macros;

public interface MacroService {
	
	List<Macros> listAllMacros();
	Macros getMacros(int macroId);
	Macros create(Macros newMacros);
	Macros update(int macroId, Macros newMacro);
	boolean delete(int macroId);

}
