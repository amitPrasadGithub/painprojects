package com.vbesfb.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContactHelper {
	public ContactHelper() {
		File file = new File("E:\\Other\\Ex\\vbesfb\\VB_Database\\contact\\contact_1.txt");
		readFile(file);
	}
	public void readFile(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = "";
			
			while ((line = reader.readLine()) != null) {
				boolean isPresent = getContact(line, "amit");
				if(isPresent) {
					BufferedReader addressReader = new BufferedReader(new FileReader("E:\\Other\\Ex\\vbesfb\\VB_Database\\addresses\\addresses_1.txt"));
					String a_line = "";
					
					while((a_line = addressReader.readLine()) != null) {
						String[] a_str = a_line.split(",");
						System.out.print("\n"+getAddress(a_line, a_str[0]));
						break;
					}	
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public boolean getContact(String line, String fname) {
		String[] list = line.split(",");
		List<String> m_list = Arrays.asList(list);
		ArrayList<String> n_list = new ArrayList<String>();
		for(String s:m_list) {
			String finalWord = enhancedRemoveQuotes(s);
			n_list.add(finalWord);
		}
		if(fname.equalsIgnoreCase(n_list.get(1))) {
			return true;
		}
		return false;
		
	}
	public String getAddress(String line, String id) {
		String[] str = line.split(",");
		List<String> list = Arrays.asList(str);
		ArrayList<String> n_list = new ArrayList<String>();
		
		for(String l:list) {
			String finalWord = enhancedRemoveQuotes(l);
			n_list.add(finalWord);
		}
		if(n_list.get(0) != null) return n_list.get(1)+" "+n_list.get(2)+" "+n_list.get(3);
		return null;
	}
	public String removeQuotes(String str) {
		char[] ch = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(char c:ch) {
			if(c == (char)34) continue;
			else sb.append(c);
		}
		return sb.toString();
	}
	public String enhancedRemoveQuotes(String str) {
		return str.substring(str.indexOf('"')+1, str.lastIndexOf('"'));
	}
}
