import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Ex1_Annotation {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	@PostConstruct
	public void init1() {
		System.out.print("\n My Own Init");
	}
	@PreDestroy
	public void destroy1() {
		System.out.print("\n My own Destroy");
	}
}
