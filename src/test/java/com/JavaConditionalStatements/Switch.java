package com.JavaConditionalStatements;

public class Switch {

	public static void main(String[] args) {
		int numbers=5;
		char ch='e';
		
		switch(ch){
		case 'a':
			System.out.println("Vowel");
			break;
			
		case'e':
			System.out.println("Vowel");
			break;
			
		case 'i':
			System.out.println("Vowel");
			break;
			
		case 'o':
			System.out.println("Vowel");
			break;
			
		case 'u':
			System.out.println("Vowel");
			break;
			
		default:
			System.out.println("Consonant");
		}
		
		switch(numbers) {
		case 1:
			System.out.println("1");
			break;
			
		case 2:
			System.out.println("2");
			break;
			
		case 3:
			System.out.println("3");
		break;
		case 4:
			System.out.println("4");
			break;
			
		case 5:
			System.out.println("5");
		break;
		
		default :
			System.out.println("Out of numbers");
		}
	}
	

}
