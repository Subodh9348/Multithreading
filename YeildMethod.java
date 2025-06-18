package com.subodh.Multithreading;
class MyThread1 extends Thread{
	public void run() {
		for(int i=0;i<=3;i++) {
			System.out.println("run start.."+i);
			//Thread.yield();
		}
		
	}
}

public class YeildMethod {

	public static void main(String[] args) {
		System.out.println("main start..");
		MyThread1 t1=new MyThread1();
		MyThread1 t2=new MyThread1();
		t1.start();
		Thread.yield();
		t2.start();
		System.out.println("main end...");
		

	}

}
