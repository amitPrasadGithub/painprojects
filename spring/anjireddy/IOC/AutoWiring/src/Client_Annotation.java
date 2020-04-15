import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_Annotation {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spconfig_annotation.xml");
		
		Ex1_Annotation ex1 = ctx.getBean("ex1", Ex1_Annotation.class);
		ex1.show();
	}
}
