package com.skilldistillery.fitness.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Macros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String food;
	
	private double protein;
	
	private double fat;
	
	private double carbohydrates;
	
	private double calories;
	
	@Column(name = "serving_size")
	private String servingSize;
	
	@Column(name = "number_of_servings")
	private int numOfServings;
	
	private String meal;	

	public Macros() {
		super();
	}

	public Macros(int id, String food, double protein, double fat, double carbohydrates, double calories,
			String servingSize, int numOfServings, String meal) {
		super();
		this.id = id;
		this.food = food;
		this.protein = protein;
		this.fat = fat;
		this.carbohydrates = carbohydrates;
		this.calories = calories;
		this.servingSize = servingSize;
		this.numOfServings = numOfServings;
		this.meal = meal;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public String getServingSize() {
		return servingSize;
	}

	public void setServingSize(String servingSize) {
		this.servingSize = servingSize;
	}

	public int getNumOfServings() {
		return numOfServings;
	}

	public void setNumOfServings(int numOfServings) {
		this.numOfServings = numOfServings;
	}

	public String getMeal() {
		return meal;
	}

	public void setMeal(String meal) {
		this.meal = meal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Macros other = (Macros) obj;
		return id == other.id;
	}
	
	
}
