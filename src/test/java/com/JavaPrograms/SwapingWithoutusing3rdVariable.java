package com.JavaPrograms;

public class SwapingWithoutusing3rdVariable {

	public static void main(String[] args) {

int a=10;
int b=17;

//Out put b=10 ,a=17

a=a+b;
System.out.println(a);

b=a-b;
System.out.println("B value :" + b);

a=a-b; 
System.out.println("A value: "+ a);


	}

}
