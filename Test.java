import java.util.*;
import java.io.*;
import java.sql.*;


public class Test {
	Scanner sc = new Scanner(System.in);
	
	public void armStrong() {
		System.out.print("\n Enter any number to check armstrong :: ");
		int number = sc.nextInt();
		int original = number;
		int remainder, sum=0;
		
		while(number != 0) {
			remainder = number%10;
			sum = sum+(remainder*remainder*remainder); 
			number = number / 10;
		}
		if(original == sum)
			System.out.print("\n Armstrong Number");
		else 
			System.out.print("\n Not an armstrong number");
		
	}
	public void palindromeNumber() {
		System.out.print("\n Enter any number :: ");
		int number = sc.nextInt();
		int original = number, sum = 0, remainder;
		while(number != 0) {
			remainder = number % 10;
			sum = (sum*10) + remainder;
			number = number / 10;
		}
		if(original == sum)
			System.out.print("\n Palindrome");
		else 
			System.out.print("\n No Palindrome");
		
	}
	public void palindromeString() {
		System.out.print("\n Enter any String :: ");
		String str = sc.nextLine();
		String str2 = "";
		for(int i=(str.length()-1); i>=0; i--) {
			str2 = str2+str.charAt(i);
		}
		System.out.print("\n reverse of String is :: "+str2);
	}
	
	public void sentenceReverse() {
		System.out.print("\n Enter any sentence :: ");
		String str = sc.nextLine();
		int words = findTotalWords(str);
		String[] str2 = new String[words];
		
		
		for(int i=0; i<str2.length; i++) {
			String temp = "";
			for(int j=0; j<str.length(); j++) {
				if(str.charAt(j) == (char)32) 
					str2[i] = temp;
				else
					temp = temp + str.charAt(j);
			}
		}
		for(int i=(str2.length)-1; i>=0; i--) {
			System.out.print("\t"+str2[i]);
		}
		System.out.print("\n \n Its a task \n agar crack kar liya then u r pass");
		
		
	}
	
	public int findTotalWords(String str) {
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) == (char)32)
				count++;
		}
		return count+1;
	}
	public void printASCII() {
		for(int i=0; i<300; i++) {
			System.out.print("\n "+i+" = "+(char)i);
		}
	}
	public static void main(String[] args) {
		while(true) {
			System.out.print("\n \n");
			System.out.print("\n 1. ArmStrong number");
			System.out.print("\n 2. Palindrome number");
			System.out.print("\n 3. Palindrome String");
			System.out.print("\n 4. Print all ASCII");
			System.out.print("\n 5. Find total words count in sentence");
			System.out.print("\n 6. Reverse of sentence");
			
			System.out.print("\n Enter your choice => ");
			int choice = new Scanner(System.in).nextInt();
			switch(choice) {
				case 1:
					new Test().armStrong();
					break;
				case 2:
					new Test().palindromeNumber();
					break;
				case 3:
					new Test().palindromeString();
					break;
				case 4:
					new Test().printASCII();
					break;
				case 5:
					int i = new Test().findTotalWords("i am mark");
					System.out.print("\n total words :: "+i);
					break;
				case 6:
					new Test().sentenceReverse();
					break;
				default:
					System.exit(0);
			}
		}
	}
	
}