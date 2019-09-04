package com.programs;

public class CustomTreeSet {
	static CustomTreeSet[] cts = null;
	int in = 0;
	String str = null;
	int lIndex = 0;
	
	CustomTreeSet() {
		CustomTreeSet ct = new CustomTreeSet(1);
	}
	CustomTreeSet(boolean b) {
		
	}
	CustomTreeSet(int i) {
		this.cts = new CustomTreeSet[10];
		CustomTreeSet ct = new CustomTreeSet(true);
		ct.setInt(1);
		ct.setString("Java SE");
		ct.add(ct);
	}
	public void add(CustomTreeSet cts, int index) {
		this.cts[index] = cts;
		if(index == ((this.cts.length)-1)) {
			newSize();
		}
		this.lIndex = index+1;
	}
	public void newSize() {
		CustomTreeSet[] local = new CustomTreeSet[(this.cts.length)*2];
		for(int i=0; i<this.cts.length; i++) {
			local[i] = this.cts[i];
		}
		this.cts = local;
	}
	public CustomTreeSet get(int index) {
		return this.cts[index];
	}
	public void setInt(int in) {
		this.in = in;
	}
	public int getInt() {
		return this.in;
	}
	public void setString(String str) {
		this.str = str;
	}
	public String getString() {
		return this.str;
	}
	public void add(CustomTreeSet cts) {
		if(this.lIndex == 0)
			add(cts, 0);
		else {
			add(cts, this.lIndex);
		}
	}
	public int getIndex() {
		return this.lIndex;
	}
}
