package com.javatest;

import java.util.Locale;

public class Javapractise {
	
	public static void main(String[] arg) {
		
		String S1="Automation";
		String S2="Automation";
		String S6="AutomaTion";
		String S3="Selenium";
		String S4=new String("Testings world with seleniums");
		String S7=new String("Testings world with seleniums");
		S1=S3.concat("Mahendra");
		//System.out.println(S1);
		//System.out.println(S1);
		//System.out.println(S2);
		/*
		 * System.out.println(S3); System.out.println(S4);
		 * System.out.println(S1.equals(S2));
		 * System.out.println(S1.compareToIgnoreCase(S2)); System.out.println(S1==S2);
		 */
		System.out.println(S2.compareTo(S6));
		System.out.println(S6.compareTo(S3));
		System.out.println(50+25+S1+" Mahe"+10+11);
		System.out.println("Length of " +S1.length());
		System.out.println("CharIt  " + S1.charAt(4));
		System.out.println(S2.compareToIgnoreCase(S6));
		System.out.println(S2.contains(S6));
		System.out.println(S2.isBlank());
		System.out.println("Substring of " + S2.substring(4,8));
		System.out.println("Substring of " + S2.substring(4));
		System.out.println(S3.indexOf(5));
		System.out.println(S3.toCharArray());
		String S9= S4.intern();
		String S10= S7.intern();
		System.out.println(S9==S10);
		System.out.println(S4==S7);
		String A1="Mahendra ";
		String A2="Nagireddy ";
		String A3=new String(" Reddy");
		String concat="Concatination of the string " + A1+A2;
		String concat1= A1+A3;
		
		char chartat=A1.charAt(2);
		System.out.println("Char at value   "+ chartat);
		
		String substr="Sub string of the string  " + A1.substring(2,5);
		System.out.println(substr);
		
		int len=A1.length();
		System.out.println("Length of the string " + len);
		
		 boolean str=concat1.contains("Mahendra");
		 System.out.println(str);
		 
		 String join1=String.join("-","Welcome ", " To ", "join ");
		 String join2=String.join("/","08", "11", "2021");
		 System.out.println(join1);
		 System.out.println(join2);
		 
		 String B1="Mahendra";
		 String B2="reddy";
		 String B3="Mahendra";
		 boolean eql=B1.equals(B3);
		 boolean eql1=B2.equals(B1);
		 System.out.println("Equal values of  "+eql);
		 System.out.println("Equal values of  "+eql1);
		 
		 boolean isempt=B1.isEmpty();
		 System.out.println("Is Empty method  "+isempt);
		 
		 String conct=B1.concat(B2);
		 String conct1=B1.concat(" Learning the selenium");
		 System.out.println(conct);
		 System.out.println(conct1);
		 
		 String rlp=B1.replace("a", "Sai");
		 System.out.println(rlp);
		 String rlp1=B2.replace("r", "Sai");
		 System.out.println(rlp1);
		 String rlp2=B1.replace("a", "Sai");
		 System.out.println(rlp2);
		 String rlp3=B2.replace("redd", "Sai");
		 System.out.println(rlp3);
		 
		 boolean IgcaseS=B1.equalsIgnoreCase(B3);
		 //IgcaseS = "geeks".equalsIgnoreCase("geeks");
		 System.out.println(IgcaseS);
		 String B5="mahendra reddy Nagi reddy";
		 boolean Ige=B1.equalsIgnoreCase(B5);
		 System.out.println(Ige);
		 
		 String[] splt=B5.split("\s",2);
		 for(String w:splt) {
			 System.out.println(w);
		 }
		 String[] splt1=B5.split("\s");
		 for(String w:splt1) {
			 System.out.println(w);
		 }
		 
		 
		 String C1="Mahendra";
		 String C3=new String("Mahendra");
		 String C4=C3.intern();
		 boolean C5=C1==C4;
		 System.out.println(C5);
		 System.out.println(C1==C3);
		 
		 int indexValue=B5.indexOf("reddy");
		 System.out.println(indexValue);
		 int indexValue1=B5.indexOf("dra");
		 System.out.println(indexValue1);
		 int indexValue2=B5.indexOf("G");
		 System.out.println(indexValue2);
		 int indexValue3=B5.indexOf("reddy", 15);
		 System.out.println(indexValue3);
		 int indexValue4=B5.indexOf("r", 15);
		 System.out.println(indexValue4);
		 
		 String S = "JAVATPOINT HELLO stRIng";
		 String lowerCase=S.toLowerCase();
		 System.out.println(lowerCase);
		 String lowerCase1=S.toLowerCase(Locale.ENGLISH);
		 System.out.println(lowerCase1);
		 String lowerCase2=S.toLowerCase(Locale.forLanguageTag("tr"));
		 System.out.println(lowerCase2);
		 
		 String D1 = " javapoint hello string ";
		 String upperCase=D1.toUpperCase();
		 System.out.println(upperCase);
		 String upperCase1=D1.toUpperCase(Locale.forLanguageTag("tr"));
		 System.out.println(upperCase1);
		 
		 String trim=D1.trim();
		 System.out.println(trim);
		 
		 boolean b=true;
		 boolean b1=false;
		 String bol=String.valueOf(b1);
		 String bol1=String.valueOf(b);
		 System.out.println(bol);
		 System.out.println(bol1);
		 
		 byte b2=11;    
	        short sh = 12;  
	        int i = 13;  
	        long l = 14L;  
	        float f = 15.5f;  
	        double d = 16.5d;  
	        char chr[]={'j','a','v','a'};
	        System.out.println(b2);
	        System.out.println(sh);
	        System.out.println(i);
	        System.out.println(l);
	        System.out.println(f);
	        System.out.println(d);
	        System.out.println(chr);
	        
		 
		String Str1= String.format("%f", 101.15);
		System.out.println(Str1);
				
		System.out.println(A2.concat(concat1));
		System.out.println(concat);
		System.out.println(concat1);		
		}

	
	

}
