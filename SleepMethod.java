package com.subodh.Multithreading;
class MyThread2 extends Thread{
	public void run() {
		for(int i=0;i<=3;i++) {
			System.out.println("run start.."+i);
			//Thread.yield();
		}
		
	}
}

public class SleepMethod {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("main start..");
		MyThread1 t1=new MyThread1();
		MyThread1 t2=new MyThread1();
		//t1.start();
		//Thread.yield();
		Thread.sleep(5000);
		t2.start();
		System.out.println("main end...");
		

	}

}
