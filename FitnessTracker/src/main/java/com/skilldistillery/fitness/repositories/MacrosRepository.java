package com.skilldistillery.fitness.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.fitness.entities.Macros;

public interface MacrosRepository extends JpaRepository <Macros, Integer> {

	
}
