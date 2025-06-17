package com.subodh.Multithreading;
class MyThread extends Thread{
	public void run() {
		for(int i=0;i<=3;i++){
			
			System.out.println("running..."+i);
			try {
				Thread.sleep(5000);
			}catch(InterruptedException e){
				System.out.println(e);
				
			}
		}
		
	}
}

public class IsAlive {

	public static void main(String[] args) throws InterruptedException {
		MyThread t=new MyThread();
		System.out.println("before start.."+t.isAlive());
		t.start();
		//t.run();
		System.out.println("after start.."+t.isAlive());
		t.join();
		System.out.println("finished.."+t.isAlive());
		

	}

}
