import org.springframework.beans.factory.annotation.Autowired;

public class Ex1_Annotation {
	private Ex2_Annotation ex2;
	
	public Ex2_Annotation getEx2() {
		return ex2;
	}

	@Autowired
	public void setEx2(Ex2_Annotation ex2) {
		this.ex2 = ex2;
	}
	
	public void show() {
		getEx2().m1();
	}
	
}
