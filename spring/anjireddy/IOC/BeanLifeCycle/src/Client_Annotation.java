import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client_Annotation {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = 
				new ClassPathXmlApplicationContext("spconfig_annotation.xml");
		ctx.close();
	}
}
