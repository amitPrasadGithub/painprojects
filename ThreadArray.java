import java.io.*;

class ThreadArray {
	static CreatingThread[] th = new CreatingThread[10];
	public static void main(String[] args) {
		for(int i=0; i<10; i++) {
			th[i] = new CreatingThread(i);
			th[i].start();
		}
	}
}
class CreatingThread extends Thread {
	int i= 0;
	CreatingThread(int i){
		this.i = i;
	}
	public void run() {
		System.out.print("\n Thread :: "+i);
	}
}