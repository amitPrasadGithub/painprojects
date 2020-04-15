import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client_mkYong {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("spconfig_mkyong.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Object obj = factory.getBean("PersonBean");
	}
}
