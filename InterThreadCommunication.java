package com.subodh.Multithreading;
class Factory{
	private int items;
	private boolean itemsAvailable;
	synchronized void produce(int items) {
		if(itemsAvailable) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.items=this.items+items;
		System.out.println("items produced.."+items);
		itemsAvailable=true;
		
		notify();
	}
	
	synchronized void consume(int items){
		if(!itemsAvailable) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.items=this.items-items;
		System.out.println("items consumed.."+items);
		itemsAvailable=false;
		
		notify();
	}
}
class Producer implements Runnable{
	private Factory factory;

	public Producer(Factory factory) {
		this.factory = factory;
	}

	@Override
	public void run() {
		for(int i=1;i<=5;i++){
			factory.produce(i);
		}
		
	}
	
}
class Consumer implements Runnable{
	private Factory factory;

	public Consumer(Factory factory) {
		this.factory = factory;
	}

	@Override
	public void run() {
		for(int i=1;i<=5;i++){
			factory.consume(i);
		}
		
	}
	
}

public class InterThreadCommunication {

	public static void main(String[] args) {
		Factory factory=new Factory();
		
		new Thread(new Producer(factory)).start();
		new Thread(new Consumer(factory)).start();
		
	}

}
