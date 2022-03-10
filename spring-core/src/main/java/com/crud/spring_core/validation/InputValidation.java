package com.crud.spring_core.validation;

import java.util.Scanner;

public class InputValidation {

	public static String inputStringValidation() {
		Scanner sc=new Scanner(System.in);
		while(!sc.hasNext("[A-Za-z]*")) {
			System.out.println("That's not alphabets !\n"+"Please enter an Alphabets :: ");
			sc.next();
		}
		String name=sc.nextLine();
		System.out.println("Thank you! "+name+" \n" );
		return name;
	}
	
	public static int inputIntegerValidation() {
		Scanner sc=new Scanner(System.in);
		int number;
		do {
			System.out.println("[Please enter positive number ]:: ");
			while(!sc.hasNextInt()) {
				System.out.println("That's not a number !\n"+"Please enter a positive number ::");
				sc.next();
			}
			number=sc.nextInt();
		}while(number<=0);
		System.out.println("Thank you!"+number+"\n");
		return number;
	}
	

	
}
