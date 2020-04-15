package com.constructorInjection.mockObject;

public class B {	
	private A a;

	public B(A a) {
		this.a = a;
		show();
	}
	public void show() {
		System.out.print("\n"+a);
	}
}
