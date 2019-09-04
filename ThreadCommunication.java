package com.programs;

public class ThreadCommunication implements Runnable  {
	static int total = 0;
	
	ThreadCommunication() {
		ThreadCommunication tc = new ThreadCommunication(1);
		Thread t1 = new Thread(tc);
		t1.start();
	}
	ThreadCommunication(int a) {

	}
	public void run() {
		for(int i=0; i<100; i++) {
			ThreadCommunication.total = ThreadCommunication.total + i;
		}
	}
	
}
