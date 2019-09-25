package com.cipherdata.dazl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class DAZLServiceHandler {
	LinkedList<Integer> job = new LinkedList<>();
	
	String root_location = "/root";
	String m_file	= "/root/file";
	
	public DAZLServiceHandler() {
		job.add(123);
		File file = new File(m_file);
		fileCreation(file);
	}
	public void fileCreation(File file) {
		String line = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line=br.readLine()) != null) {
				String[] words = line.split(" ");
				if(words[0].equalsIgnoreCase("MBX:")) {
					masterJobCreation_MBX(br, line);
				}
			}
		}	
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void masterJobCreation_MBX(BufferedReader br, String line) {
		int masterJob = returnMasterJob();
		
		try {
			while((line=br.readLine()) != null) {
				String[] words = line.split(" ");
				if(words[0].equalsIgnoreCase("HDRDISTRIBUTION")) {
					String fileName = masterJob+"_Dis";
					String m_file = root_location + "/" + fileName;
					createFile(br, m_file);
				}
				else if(words[0].equalsIgnoreCase("HDRPRICE")) {
					String fileName = masterJob + "_Pri";
					String m_file = root_location + "/" + fileName;
					createFile(br, m_file);
				}
				else if(words[0].equalsIgnoreCase("HDRNAME")) {
					String fileName = masterJob + "_Nam";
					String m_file = root_location + "/" + fileName;
					createFile(br, m_file);
				}
				else if(words[0].equalsIgnoreCase("HDRPOSITION")) {
					String fileName = masterJob + "_Pos";
					String m_file = root_location + "/" + fileName;
					createFile(br, m_file);
				}
				else if(words[0].equalsIgnoreCase("++++")) return;
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	public LinkedList<Integer> createJob(LinkedList<Integer> in) {
		int i = in.getLast();
		in.addLast(i+1);
		return in;
	}
	public int returnMasterJob() {
		int masterJob = 0;
		if(job.size() == 1)	{
			masterJob = job.getFirst();
			this.job = createJob(job);
		}
		else {
			masterJob = job.getLast();
			this.job = createJob(job);
		}
		return masterJob;
	}
	public void createFile(BufferedReader br, String fileType) {
		String line = "";
		BufferedWriter bwr = null;
		StringBuffer sb = new StringBuffer();
		
		File file = new File(fileType);
		try {
			bwr = new BufferedWriter(new FileWriter(file));
			while ((line=br.readLine()) != null) {
				String[] words = line.split(" ");
				if(words[0].contains("TRL")) {
					bwr.write(sb.toString());
					return;
				}
				else if(words[0].contains("FTRL")) return;
				else {
					sb.append(line);
					sb.append("\n");
				}
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bwr.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
