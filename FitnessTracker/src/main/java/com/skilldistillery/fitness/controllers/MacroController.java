package com.skilldistillery.fitness.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.fitness.entities.Macros;
import com.skilldistillery.fitness.services.MacroService;

@RestController
@RequestMapping("api")
public class MacroController {
	
	@Autowired
	private MacroService macroService;
	
	@GetMapping("macros")
	List<Macros> listMacros() {
		return macroService.listAllMacros();
	}

}
