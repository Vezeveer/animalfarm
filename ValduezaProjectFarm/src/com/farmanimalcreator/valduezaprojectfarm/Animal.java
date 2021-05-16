package com.farmanimalcreator.valduezaprojectfarm;

public class Animal {
	public static String speak(String animalType){
		if(animalType.equals("dog"))
			return "Woof! Woof!";
		else if(animalType.equals("cat"))
			return "Meow!";
		else if(animalType.equals("pig"))
			return "Oink! Oink!";
		else if(animalType.equals("horse"))
			return "Burrr! Durr";
		else
			return "Moooo!";
	}
}
