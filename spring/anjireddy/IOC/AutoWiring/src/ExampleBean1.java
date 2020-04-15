public class ExampleBean1 {
	private ExampleBean2 eb2;

	public ExampleBean2 getEb2() {
		return eb2;
	}

	public void setEb2(ExampleBean2 eb2) {
		this.eb2 = eb2;
	}
	
	public void show() {
		getEb2().m1();
	}
}
