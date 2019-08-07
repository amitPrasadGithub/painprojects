import java.util.*;
import java.io.*;

class SystemScanner {
	static int count = 0;
	BufferedReader br = null;
	public void scan(String fileName, String keyword) {
		try {
			br = new BufferedReader(new FileReader(fileName));
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = null;
	try {
		while((line=br.readLine()) != null) {
			String[] str = line.split(" ");
			int count1 = getCount(str, keyword);
			SystemScanner.count = SystemScanner.count + count1;
		}
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	}
	public int getCount(String[] str, String keyword) {
		int count = 0;
		for(String s:str) {
			System.out.print("\t"+s);
			if(s.equals(keyword)) {
				count++;
			}
		}
		return count;
	}
}
class Processor implements Runnable {
	SystemScanner sc;
	String fileName = null;
	String keyword = null;

	Processor(SystemScanner sc, String fileName, String keyword) {
		this.sc = sc;
		this.fileName = fileName;
		this.keyword = keyword;
	}

	public void run() {
		sc.scan(fileName, keyword);
		System.out.print("\n Thread Name :: "+Thread.currentThread().getName());
		System.out.print("\n Thread "+Thread.currentThread().getName()+" completed Execution");
	}

}
class ServiceHandler {

	public static void main(String[] args) {
		SystemScanner sc = new SystemScanner();
		Processor p1 = new Processor(sc, "file1.txt", "Hi");
		Processor p2 = new Processor(sc, "file2.txt", "Hi");
		Processor p3 = new Processor(sc, "file3.txt", "Hi");
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(p3);
		t1.start();
		try {t1.join();} catch(InterruptedException e) {}
		t2.start();
		try {t2.join();} catch(InterruptedException e) {}
		t3.start();
		try {t3.join();} catch(InterruptedException e){}

		System.out.print("\n Count :: "+SystemScanner.count);
		System.out.print("\n Main thread finished");
	}
}
