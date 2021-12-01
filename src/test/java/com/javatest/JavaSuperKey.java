package com.javatest;

public class JavaSuperKey {
	void eat(){
		System.out.println("Eating....");
	}
	
	class child extends JavaSuperKey {
		void bark() {
			System.out.println("Barking...");
		}
		
		void eat() {
			System.out.println("Eating....");
		}
		
		void work() {
			super.eat();
			eat();
			bark();
		}
		
	}
	
	public class SuperInvokesParentClassMethod{
		
		public void main(String args[]) {
			
			child c=new child();
			c.work();
			
		}
	}

}
