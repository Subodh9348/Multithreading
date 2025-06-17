package com.subodh.Multithreading;

class Addition1{
	private static int x;
	private static int y;

 //void add(int x,int y) {
	static synchronized void add(int x,int y) {
	 Addition1.x=x;
	 Addition1.y=y;
	 try {
		 Thread.sleep(5000);
	 }catch(InterruptedException e){
		 e.printStackTrace();
	 }
	 int res=Addition1.x+Addition1.y;
	 System.out.println(Thread.currentThread().getName()+"result:"+res);
  }
}
 class Thread3 extends Thread{
	 
	 public void run() {
		 Addition1.add(70, 80);
	 }
	
	
 }
 class Thread4 extends Thread{
	
	 public void run() {
		 Addition1.add(50, 60);
	 }
	
 }

public class StaticSynchronization {

	public static void main(String[] args) {
		
		Thread3 t1=new Thread3();
		Thread4 t2=new Thread4();
		t1.start();
		t2.start();
	}

}
