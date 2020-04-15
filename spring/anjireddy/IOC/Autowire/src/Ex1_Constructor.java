public class Ex1_Constructor {
	private Ex2_Constructor ex2;

	public Ex1_Constructor(Ex2_Constructor ex2) {
		this.ex2 = ex2;
	}
	public void show() {
		ex2.m1();
	}
}
