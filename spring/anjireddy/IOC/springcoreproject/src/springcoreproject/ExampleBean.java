package springcoreproject;

public class ExampleBean {
	private DemoBean db;

	public DemoBean getDb() {
		System.out.print("\n"+db);
		return db;
	}

	public void setDb(DemoBean db) {
		this.db = db;
	}
}
