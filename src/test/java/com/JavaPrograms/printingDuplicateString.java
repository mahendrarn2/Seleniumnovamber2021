package com.JavaPrograms;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class printingDuplicateString {

	public static void main(String[] args) {
		
		printDuplicateCharacters("Hi How are you doing");

	}
String str="";

	private static void printDuplicateCharacters(String word) {
		
		char[] characters=word.toCharArray();
		
		//Build HashMap with character and number of times they appear in string
		
		HashMap<Character,Integer> charMap=new HashMap<Character,Integer>() ;
		
		for (Character ch : characters) {
			
			if (charMap.containsKey(ch)) {
				
				charMap.put(ch, charMap.get(ch)+1);
				
			}else {
				
				charMap.put(ch, 1);
				
			}
			
		}
		//Iterate through HashMap to print all duplicate characters of string
		Set<Map.Entry<Character,Integer>> entrySet = charMap.entrySet();
		System.out.printf("List of duplicates chaarcters in string '%s' %n", word);
		
		for (Map.Entry<Character,Integer> entry : entrySet) {
			if (entry.getValue()>1) {
				System.out.printf("%s : %d %n", entry.getKey(), entry.getValue());
			}
		}
		
		
	}

		
	}


