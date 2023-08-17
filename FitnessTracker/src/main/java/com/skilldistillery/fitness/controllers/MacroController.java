package com.skilldistillery.fitness.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin({"*", "http://localhost/"})
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
	Macros getMacrosById(@PathVariable("id") Integer macrosId, HttpServletResponse res) {
		Macros macros = macroService.getMacros(macrosId);
		if( macros == null) {
			res.setStatus(404);
		}
		return macros;
		
	}
	
	@PostMapping("macros")
	Macros createMacros(@RequestBody Macros macros, HttpServletResponse res, HttpServletRequest req) {
				try {
					macros = macroService.create(macros);
					res.setStatus(201);
					StringBuffer url = req.getRequestURL();
					url.append("/").append(macros.getId());
					res.setHeader("Location", url.toString());
				} catch (Exception e) {
					e.printStackTrace();
					res.setStatus(400);
					macros = null;
				}
				return macros;
	}
	
	@PutMapping("macros/{id}")
	Macros updateMacros(@PathVariable ("id") Integer macrosId, @RequestBody Macros macros, HttpServletResponse res) {
				try {
					macros = macroService.update(macrosId, macros);
					if(macros == null) {
						res.setStatus(404);
					}
				} catch (Exception e) {
					e.printStackTrace();
					res.setStatus(400);
					macros = null;
				}
				return macros;
	}
	
	@DeleteMapping("macros/{id}")
	public void deleteMacros(@PathVariable("id") Integer macrosId, HttpServletResponse res) {
		try {
			if(macroService.delete(macrosId)) {
				res.setStatus(204);
			}else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
		}
	
	}
}
