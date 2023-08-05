package com.skilldistillery.fitness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.fitness.entities.Macros;
import com.skilldistillery.fitness.repositories.MacrosRepository;

@Service
public class MacroServiceImpl implements MacroService {
	
	@Autowired
	private MacrosRepository macroRepo;

	@Override
	public List<Macros> listAllMacros() {
		return macroRepo.findAll();
	}

	@Override
	public Macros getMacros(int macroId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Macros create(Macros newMacros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Macros update(int macroId, Macros newMacro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int macroId) {
		// TODO Auto-generated method stub
		return false;
	}

}
