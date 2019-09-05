package com.programs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class OutputFormat extends DefaultHandler {
	File inputFile = null;
	File outputFile = null;
	File temp = null;
	BufferedReader br = null;
	BufferedWriter bw = null;
	String start = null;
	String end = null;
	boolean newLine = false;
	String space = "  ";
	StringBuffer sb = new StringBuffer();
	StringBuffer root = new StringBuffer();
	
	OutputFormat() {
		files();
		writeTempFile();
		init();
	}
	
	public void init() {
		try {
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void files() {
		this.inputFile = new File("E:\\Other\\Ex\\vbesfb\\Programs\\src\\com\\resources\\config.xml");
		this.outputFile = new File("E:\\Other\\Ex\\vbesfb\\Programs\\src\\com\\resources\\outputFile.xml");
	}
	public void writeTempFile() {
		try {
			String line = "";
			br = new BufferedReader(new FileReader(this.inputFile));
			while((line = br.readLine()) != null) {
				this.temp = new File("E:\\Other\\Ex\\vbesfb\\Programs\\src\\com\\resources\\temp.xml");
				char[] ch = line.toCharArray();
				
				for(char c:ch) {
					if((int)c == 47) {
						sb.append(c);
						this.newLine = true;
					}
					else if((int)c == 62) {
						sb.append(c);
						if(newLine) {
							sb.append("\n");
							addSpace();
							sb.append(space);
							newLine = false;
						}
					}
					else {
						sb.append(c);
					}
				}
				bw = new BufferedWriter(new FileWriter(this.temp));
				bw.write(sb.toString());
				bw.flush();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void addSpace() {
		this.space = this.space + "  ";
	}
}
