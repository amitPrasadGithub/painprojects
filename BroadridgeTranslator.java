package com.cipherdata.base.broadridge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class BroadridgeTranslator {
	public static final String CRAWLER		= "D:\\Project_\\VB\\Custodians\\Broadridge\\crawler";
	public static final String TRANSLATOR	= "D:\\Project_\\VB\\Custodians\\Broadridge\\Translator";
	
	public BroadridgeTranslator() {
		start();
	}
	public void start() {
		File crawler		= new File(CRAWLER);
		String[] fileList 	= crawler.list();
		
		for(String s:fileList) {
			File file = new File(CRAWLER + File.separator + s);
			if(file.isFile()) {
				String extension = s.substring(s.lastIndexOf(".")+1);
				if(extension.equalsIgnoreCase("pol")) {
					policy(file);
				}	
			}
		}
	}
	public void policy(File file) {
		int count = 0;
		BufferedWriter bw = null;
		ArrayList cvsRow = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line=br.readLine()) != null) {
				String[] str = line.split(",");
				if(str[0].equalsIgnoreCase("I41")) {
					cvsRow = new ArrayList();
					if(count == 0) {
						bw = new BufferedWriter(new FileWriter(TRANSLATOR + File.separator + "_I41"));
						count++;
					}	
					for(String s:str) {
						String raw = removeQuotes(s);
						String finalStr = surroundQuotes(raw);
						cvsRow.add(finalStr);
					}
					cvsRow = removeElements(cvsRow, new int[] {24,9,0});
					String finalRow = formatArrayList(cvsRow);
					bw.write(finalRow);
					bw.write("\n");
					bw.flush();
				}
				if(str[0] == "I49" && str[1] == "3701") {
					bw.close();
					count = 0;
				}
			}
		}
		catch(Exception e) {
			
		}
	}
	
	/*
	 * 
	 * Generic Methods
	 */
	public String removeQuotes(String str) {
		StringBuffer sb = new StringBuffer();
		char[] ch = str.toCharArray();
		for(char c:ch) {
			if(c == '"')
				continue;
			else 
				sb.append(c);
		}
		return sb.toString();
	}
	public ArrayList removeElements(ArrayList list, int[] elements) {
		for(int elem:elements) {
			list.remove(elem);
		}
		return list;
	}
	public String surroundQuotes(String str) {
		StringBuffer sb = new StringBuffer();
		
		sb.append('"');
		sb.append(str);
		sb.append('"');
		
		return sb.toString();
	}
	public String formatArrayList(ArrayList list) {
		String raw = list.toString();
		return raw.substring(1, raw.length()-1);
	}
	
}
