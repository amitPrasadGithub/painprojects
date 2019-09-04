package com.programs;

public class SynchronizedThread implements Runnable {
	SynchronizedThread sm1 = null;
	public SynchronizedThread() {
		SynchronizedThread sm1 = new SynchronizedThread(1);
		SynchronizedThread sm2 = new SynchronizedThread(1);
		this.sm1 = sm1;
		Thread t1 = new Thread(sm1);
		t1.setName("Java");
		Thread t2 = new Thread(sm2);
		t2.setName(".Net");
		t1.start();
		t2.start();
	}
	public SynchronizedThread(int i) {
		this.sm1 = this;
	}
	public void run() {
		sm1.display();
		sm1.d1();
	}
	public static synchronized void display() {
		for(int i=0; i<10; i++) {
			System.out.print("\n Thread Name "+Thread.currentThread().getName());
		}
	}
	public synchronized void d1() {
		for(int i=0; i<10; i++) {
			System.out.print("\n just synchronized method");
		}
	}
}
