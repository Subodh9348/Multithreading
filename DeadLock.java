package com.subodh.Multithreading;
class A extends Thread{
	private B b;

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
	
	@Override
	public void run() {
		System.out.println("A Thread Start."); 
		System.out.println("A thread is calling join() on B thread.");
		try {
			b.join();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("a thread resume.");
		System.out.println("A thread end..");
	}
}
class B extends A{
	private A a;

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}
	@Override
	public void run() {
		System.out.println("B thread start");
		System.out.println("B thread is calling join() on B thread.");
		try {
			//a.join();
			a.join(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("B thread resume.");
		System.out.println("b thread end..");
	}
}
public class DeadLock {
	public static void main(String[] args) {
		A a1=new A();
		B b1=new B();
		a1.setB(b1);
		b1.setA(a1);
		a1.start();
		b1.start();
	}

}
/*
 * if the threads are in dead lock situation for a  period of time then we call as a 
 * starvation
 */
