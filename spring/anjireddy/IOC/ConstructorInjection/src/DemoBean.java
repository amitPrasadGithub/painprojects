
public class DemoBean {
	private String first;
	private String second;


	public DemoBean(String first) {
		this.first = first;
	}
	public DemoBean(String first, String second) {
		this.first = first;
		this.second = second;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getFirst() {
		return first;
	}
	public void show() {
		System.out.print(first+" ... "+second);
	}
}
