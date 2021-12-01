package com.javatest;

class Student{
	//Note: Instance variable names and local variable names are same, so we are using this keyword
	int rollno; //Instance variable
	String name;//Instance variable
	float fee;//Instance variable
	
	//Below method is accepting local variables which are having same name as instance variable as arguments
	Student(int rollno, String name, float fee){
		this.rollno=rollno;
		this.name=name;
		this.fee=fee;
	}
	void display(){
		System.out.println(rollno+ " "+name+" "+fee);
	}
}

public class ThisKeyword {
	
	public static void main(String args[]) {
		Student S1=new Student(111, "Mahi", 5000f);
		Student S2=new Student(112, "Sai", 6000f);
		S1.display();
		S2.display();
		
	}

}
