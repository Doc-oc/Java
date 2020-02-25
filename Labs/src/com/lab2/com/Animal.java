/********************
 * 
 * Animal class that describes an animal attributes
 * Author: Dylan O'Connor
 * Date: 06/02/2020
 * 
 ********************/

package com.lab2.com;

public class Animal {
	//attributes
	private String name;
	private String breed;
	private int age;
	private boolean domesticAnimal;
	private String colour;
	
	//constructors
	public Animal(String name) {
		this.name = name;
		
	}//end constructor 1
	
	public Animal(String name, String breed, int age, boolean domesticAnimal, String colour) {
		this.name = name;
		this.breed = breed;
		this.age = age;
		this.domesticAnimal = domesticAnimal;
		this.colour = colour;
	}//end constructor 2
	
	
	// printing strings
	public String toString() {
		String details = "Name: "+ name + "\nBreed: "+ breed + "\nAge: "+ age + "\nDomestic: "+ domesticAnimal +"\nColour: "+ colour;
		return details;
	}

	

	//getter and setters
	//setting and getting name
	public void setName(String animalName){
		name = animalName;
	}
	public String getName(){
		return name;
	}
	
	//setting and getting breed
	public void setBreed(String animalBreed){
		breed = animalBreed;
	}
	public String getBreed(){
		return breed;
	}
	
	//setting and getting age
	public void setAge(int animalAge){
		age = animalAge;
	}
	public int getAge(){
		return age;
	}
	
	//setting and getting domestic
	public void setDomestic(boolean domestic ){
		domesticAnimal = domestic;
	}
	public boolean getDomestic(){
		return domesticAnimal;
	}
	
	//setting and getting colour
	public void setColour(String animalColour){
		colour = animalColour;
	}
	public String getColour(){
		return colour;
	}
	
	// make noise 
	public void makeNoise(){
		
		switch(breed) {
		case "dog":
			System.out.println("\nBark");
			break;
		case "cat":
			System.out.println("\nMeow");
			break;
		case "horse":
			System.out.println("\nNeighhh");
			break;
		case "monkey":
			System.out.println("\nOo oo ah ah");
			break;
		default:
			System.out.println("Unknown Sound!");
			
		}//end switch 
	}//end make noise 
	
	
	public void makeNoise(boolean old) {
		if(old){
			old = true;
			System.out.println("Quiet animal");
		} else {
			old = false;
			makeNoise();
		}//end else 
	}
	//end makeNoise(old)
}//end Animal class















