
package com.JavaConditionalStatements;

public class NestedIfElse {

	public static void main(String[] args) {

		int age = 25;
		int weight = 42;

		if (age >= 18) {
			if (weight > 45) {
				System.out.println("You are elgible to donate the blood");
			} else {
				System.out.println("You are not elgible to donate the blood");
			}

		} else {
			System.out.println("Your age must be greater than 18");
		}
	}

}
