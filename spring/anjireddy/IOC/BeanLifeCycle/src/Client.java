import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("spconfig.xml");

		/*
		 * 
		 * to Close spring container
		 * ConfigurableApplicationContext contains implementation to close spring container
		 * destroy method called upon closing spring container
		 * 
		 */
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spconfig.xml");
		
		Ex1 ex1 = ctx.getBean("ex1", Ex1.class);
		ctx.close();
	}
}
