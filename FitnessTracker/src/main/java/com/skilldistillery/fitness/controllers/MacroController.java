package com.skilldistillery.fitness.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("macros/{id}")
	Macros getMacrosById(@PathVariable("id") Integer macrosId) {
		return macroService.getMacros(macrosId);
		
	}
	
	@PostMapping("macros")
	Macros createMacros(@RequestBody Macros macros) {
		return macroService.create(macros);
	}
	
	@PutMapping("macros/{id}")
	Macros updateMacros(@PathVariable ("id") Integer macrosId, @RequestBody Macros macros) {
		return macroService.update(macrosId, macros);
	}
	
	@DeleteMapping("macros/{id}")
	public void deleteMacros(@PathVariable("id") Integer macrosId, HttpServletResponse res) {
		if(macroService.delete(macrosId)) {
			res.setStatus(204);
		}else {
			res.setStatus(404);
		}
	
	}
}
