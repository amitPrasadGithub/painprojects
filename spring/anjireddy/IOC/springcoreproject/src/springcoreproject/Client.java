package springcoreproject;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("spconfig.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
//		WelcomeBean wb = (WelcomeBean)obj;
//		System.out.print(wb.getMessage());
		
		Object obj1 = factory.getBean("id3");
		SampleBean sb = (SampleBean)obj1;
		sb.getDb().m1();
		
		Object obj2 = factory.getBean("id4");
		ExampleBean eb = (ExampleBean)obj2;
		eb.getDb().m1();
	}
	
}
