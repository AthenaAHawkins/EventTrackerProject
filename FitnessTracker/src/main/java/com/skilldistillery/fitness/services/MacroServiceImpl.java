package com.skilldistillery.fitness.services;

import java.util.List;
import java.util.Optional;

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
	public Macros getMacros(Integer macroId) {
		Optional<Macros> macrosOpt = macroRepo.findById(macroId);
		return macrosOpt.orElse(null);
	}

	@Override
	public Macros create(Macros newMacros) {
		return macroRepo.save(newMacros);
	}

	@Override
	public Macros update(Integer macroId, Macros macro) {
		Macros newMacros = null;
		Optional<Macros> macroOpt = macroRepo.findById(macroId);
		if(macroOpt.isPresent()) {
			newMacros = macroOpt.get();
			newMacros.setFood(macro.getFood());
			newMacros.setProtein(macro.getProtein());
			newMacros.setFat(macro.getFat());
			newMacros.setCarbohydrates(macro.getCarbohydrates());
			newMacros.setCalories(macro.getCalories());
			newMacros.setServingSize(macro.getServingSize());
			newMacros.setNumOfServings(macro.getNumOfServings());
			newMacros.setMeal(macro.getMeal());
			macroRepo.saveAndFlush(newMacros);
		}
		return newMacros;
	}

	@Override
	public boolean delete(Integer macroId) {
		Optional<Macros> toBeDeleted = macroRepo.findById(macroId);
		if(toBeDeleted.isPresent()) {
			Macros toDelete = toBeDeleted.get();
			macroRepo.delete(toDelete);
			return true;
		}
		return false;
	}

}
