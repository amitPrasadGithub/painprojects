import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
	public static void main(String[] args) {
		Resource resource1 = new ClassPathResource("spconfig.xml");
		BeanFactory factory1 = new XmlBeanFactory(resource1);
		
		Resource resource2 = new ClassPathResource("spconfig1.xml");
		BeanFactory factory2 = new XmlBeanFactory(resource2, factory1);
		
		Object obj1 = factory2.getBean("traveller");
		Journey journey = (Journey)obj1;
		journey.startJourney();
		
	}
}
