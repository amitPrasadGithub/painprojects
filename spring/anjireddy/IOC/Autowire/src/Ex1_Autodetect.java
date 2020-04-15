class Ex1_Autodetect {
	private Ex2_Autodetect ex2;

	public Ex1_Autodetect(Ex2_Autodetect ex2) {
		this.ex2 = ex2;
	}
	public void show() {
		ex2.m1();
	}
}