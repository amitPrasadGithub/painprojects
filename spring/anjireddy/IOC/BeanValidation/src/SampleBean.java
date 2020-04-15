
public class SampleBean {
	private int a, b;
	private DemoBean db;
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	public DemoBean getDb() {
		return db;
	}
	public void setDb(DemoBean db) {
		this.db = db;
	}
	public void show() {
		System.out.print("\n primitive :: "+getA()+" :: "+getB());
		System.out.print("\n Objective :: "+getDb());
	}
	
}
