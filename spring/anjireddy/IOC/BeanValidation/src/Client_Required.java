import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_Required {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spconfig_required.xml");
		Employee_Required emp = ctx.getBean("emp", Employee_Required.class);
		System.out.print(emp.toString());
	}
}
