/********
 * Control Class that controls the methods of the Animal Class
 * Author Dylan O'Connor
 * Date: 06/02/2020
 *******/
package com.lab2.com;

import java.util.Scanner;

public class Control {
	
	public static void main(String[] args) {
		//objects
		Animal firstAnimal = new Animal("Spot", "dog", 4, true, "Brown");
		Animal secondAnimal = new Animal("Leo");
		Animal thirdAnimal = new Animal("Ross");
		Animal fourthAnimal = new Animal(" ");
		
		//printing objects
		System.out.println(firstAnimal);
		
		secondAnimal.setName("John");
		//String newName = secondAnimal.getName();
		
		secondAnimal.setBreed("cat");
		secondAnimal.setAge(7);
		secondAnimal.setDomestic(true);
		secondAnimal.setColour("Black");
		
		System.out.println("\n"+ secondAnimal.getName());
		
		//setting third animal breed
		thirdAnimal.setBreed("monkey");
		
		//calling make noise function
		thirdAnimal.makeNoise();
		thirdAnimal.makeNoise(true);
		
		
		// User input 
		Scanner input = new Scanner(System.in);
		
		System.out.print("\nEnter Name: ");
		fourthAnimal.setName(input.nextLine());
		
		System.out.print("Enter Breed: ");
		fourthAnimal.setBreed(input.nextLine());
		
		System.out.print("Enter Age: ");
		fourthAnimal.setAge(input.nextInt());
		
		System.out.println("\n" + fourthAnimal);
		
		
		//closing scanner
		input.close();
		
		
	}//end main

}//end control