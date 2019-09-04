package com.programs;
import java.util.Scanner;

public class StringManipulation {
	Scanner sc = new Scanner(System.in);
	
	public StringManipulation() {
		System.out.print("\n Enter any String :: ");
		String str = sc.nextLine();
		sentenceReverse(str);
	}
	
	public void sentenceReverse(String str) {
		int len = lengthOfString(str);
		int words = totalWords(str, len);
		
		String[] ar = new String[words];
		for(int i=0; i<ar.length; i++) {
			String temp = "";
			len = lengthOfString(str);
			for(int j=0; j<len; j++) {
				
				if(str.charAt(j) != (char)32) {
					temp = temp + str.charAt(j);
					if(j == (len-1)) {
						ar[i] = temp;
					}
				}
				else {
					ar[i] = temp;
					str = doSubString(str, j+1);
					break;
				}
			}
		}
		for(int i=((ar.length)-1); i>=0; i--) {
			System.out.print("\t"+ar[i]);
		}
	}
	public int lengthOfString(String str) {
		int len = 0;
		try {
			for(int i=0; str.charAt(i)!='\0'; i++) {
				len++;
			}
		}
		catch(StringIndexOutOfBoundsException e) {
			return len;
		}
		return len;
	}
	public int totalWords(String str, int len) {
		int words = 0;
		for(int i=0; i<len; i++) {
			if(str.charAt(i) == (char)32)
				words++;
		}
		return (words+1);
	}
	public String doSubString(String str, int index) {
		String temp = "";
		try {
			for(int i=index; str.charAt(i)!='\0'; i++) {
				temp = temp + str.charAt(i);
			}
		}
		catch(StringIndexOutOfBoundsException e) {
			return temp;
		}
		return temp;
	}
}