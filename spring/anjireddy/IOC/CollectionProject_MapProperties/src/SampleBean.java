import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SampleBean {
	private Map<Integer, String> emp;

	public Map<Integer, String> getEmp() {
		return emp;
	}

	public void setEmp(Map<Integer, String> emp) {
		this.emp = emp;
	}
	
	public void show() {
		Map<Integer, String> emp = getEmp();
		Set set = emp.entrySet();
		Iterator iterator = set.iterator();
		
		while (iterator.hasNext()) {
			Map.Entry me =  (Map.Entry)iterator.next();
			System.out.print("\n"+me.getKey()+ " -- "+me.getValue());
		}
	}
	
}
