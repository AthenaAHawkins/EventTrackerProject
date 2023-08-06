package com.skilldistillery.fitness.services;

import java.util.List;

import com.skilldistillery.fitness.entities.Macros;

public interface MacroService {
	
	List<Macros> listAllMacros();
	Macros getMacros(Integer macroId);
	Macros create(Macros newMacros);
	Macros update(Integer macroId, Macros Macro);
	boolean delete(Integer macroId);

}
