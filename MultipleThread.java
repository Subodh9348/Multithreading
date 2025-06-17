package com.subodh.Multithreading;

public class MultipleThread extends Thread{
	
	public void run(){
		
		Example.m1();
		Example.m2();
		Example.m3();
	}

	public static void main(String[] args) {
		Thread e1=new Thread();
		Thread e2=new Thread();
		Thread e3=new Thread();
		//Example e2=new Example();
		e1.start();
		e2.start();
		e3.start();
	}

}
