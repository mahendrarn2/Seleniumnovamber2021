package com.JavaConditionalStatements;

public class enumSwitch {

	enum Month {
		January, Februry, March, Aprial, May, June, July, August, September, October, November, December
	}

	public static void main(String[] args) {

		Month[] CurrentMonth = Month.values();

		for (Month now : CurrentMonth) {

			switch (now) {
			case January:
				System.out.println("January");
				break;

			case Februry:
				System.out.println("Febravary");
				break;

			case March:
				System.out.println("March");
				break;
				
			case Aprial:
				System.out.println("Aprial");
				break;
				
			case May:
				System.out.println("May");
				break;
				
			case June:
				System.out.println("June");
				break;
				
			case July:
				System.out.println("July");
				break;

			case August:
				System.out.println("August");
				break;

			case September:
				System.out.println("September");
				break;
				
			case October:
				System.out.println("October");
				break;
				
			case November:
				System.out.println("November");
				break;
				
			case December:
				System.out.println("December");
				break;

			}
		}

	}

}
