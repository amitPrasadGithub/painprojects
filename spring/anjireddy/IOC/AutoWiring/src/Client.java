import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("spconfig.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		ExampleBean1 eb1 = (ExampleBean1)factory.getBean("eb1");
		eb1.show();
		
	}
}
