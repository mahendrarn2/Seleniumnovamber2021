package com.JavaPrograms;

public class ProgramToReverseString {

	public static void main(String[] args) {
		
		String str="LearningJava";
		
		int strLength=str.length(); //To find the length of the string
		System.out.println(strLength);
		
		char ch[]=str.toCharArray(); //Converting string to charArray
		System.out.println(ch);
		
		for (int i=strLength-1; i>=0; i--) {
			
			System.out.print(ch[i]+" ");
		}
		
	}

}
