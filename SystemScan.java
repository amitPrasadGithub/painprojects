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
	SystemScanner sc = null;
	String fileName = null;
	String keyword = null;
	boolean isFile = false;
	Processor(String fileName, SystemScanner sc, String keyword) {
		this.fileName = fileName;
		this.sc = sc;
		this.keyword = keyword;
		
		this.isFile = checkFile(fileName);
		
	}
	public boolean checkFile(String file) {
		File f = new File(file);
		boolean is = f.isFile();
	}
	public void run() {
		if(isFile)
			sc.scan(fileName, keyword);
		else {
			String[] folders = fileName.list();
			Processor[] p = new Processor[folder.length];
			for(int i=0; i<folder.length; i++) {
				System.out.print("\t"+folder[i]);
				p[i] = new Processor(fileName, sc, keyword);
				p[i].start();
			}
		}
	}

}

class ServiceHandler {

	public static void main(String[] args) {
		SystemScanner sc = new SystemScanner();
		Processor p = new Processor("E:\Amit\Documents", sc, "public");
		Thread t = new Thread(p);
		t.start();
	}
}
