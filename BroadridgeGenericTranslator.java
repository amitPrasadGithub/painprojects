package com.cipherdata.base.broadridge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class BroadridgeGenericTranslator {
	public static final String CRAWLER		= "D:\\Project_\\VB\\Custodians\\Broadridge\\crawler";
	public static final String TRANSLATOR	= "D:\\Project_\\VB\\Custodians\\Broadridge\\Translator";

	public BroadridgeGenericTranslator() {
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
		BufferedWriter bw	= null;
		BufferedReader br 	= null; 
		try {
			br = new BufferedReader(new FileReader(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] str = line.split(",");
				if(str[0].equalsIgnoreCase("I41")) {
					File l_file = new File(TRANSLATOR + File.separator + "_I41");
					processCVSRow(l_file, new int[] {0}, br, line, str[0]);
				}
				else if(str[0].equalsIgnoreCase("I51")) {
					File l_file = new File(TRANSLATOR + File.separator + "_I51");
					processCVSRow(l_file, new int[] {}, br, line, str[0]);
				}
				else if(str[0].equalsIgnoreCase("I61")) {
					File l_file = new File(TRANSLATOR + File.separator + "_I61");
					processCVSRow(l_file, new int[] {}, br, line, str[0]);
				}
				else if(str[0].equalsIgnoreCase("I71")) {
					File l_file = new File(TRANSLATOR + File.separator + "_I71");
					processCVSRow(l_file, new int[] {}, br, line, str[0]);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void processCVSRow(File file, int[] elements, BufferedReader br, String firstLine, String fileType) {
		ArrayList cvsRow = null;
		StringBuffer sb = new StringBuffer();
		sb.append(processCVSRow(firstLine, elements));
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			String line = "";
			while ((line = br.readLine()) != null) {
				String[] str = line.split(",");
				if(!str[0].equalsIgnoreCase(fileType)) {
					bw.write(sb.toString());
					bw.write("\n");
					bw.flush();
					return;
				}
				sb.append(processCVSRow(line, elements));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public StringBuffer processCVSRow(String line, int[] elements) {
		StringBuffer sb = new StringBuffer();
		ArrayList cvsRow = new ArrayList();
		String[] str = line.split(",");

		for(String s:str) {
			String raw 		= removeQuotes(s);
			String finalStr	= surroundQuotes(raw);

			cvsRow.add(finalStr);
		}
		cvsRow 			= removeElements(cvsRow, elements);
		String finalRow	= formatArrayList(cvsRow);
		
		sb.append(finalRow);
		sb.append("\n");
		return sb;
		
	}

	/*
	 * 
	 * Generic Methods
	 * 
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
