import org.springframework.beans.factory.annotation.Required;

public class Employee_Required {
	private String name;    
    private String designation;
    private String company;
	public String getName() {
		return name;
	}
	@Required
	public void setName(String name) {
		this.name = name;
	}
	@Required
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String toString() {
		return "Name::"+getName()+" Designatin :: "+getDesignation();
	}
}
