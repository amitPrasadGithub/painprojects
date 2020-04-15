import java.util.Iterator;
import java.util.Set;

public class SampleBean {
	private Set set;

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}
	public void show() {
		Set set = getSet();
		Iterator itr = set.iterator();
		while(itr.hasNext()) {
			System.out.print("\n"+itr.next());
		}
	}
}
