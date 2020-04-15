import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

class Client_Constructor {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("spconfig_constructor.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Object obj = factory.getBean("ex1");
		Ex1_Constructor ex1 = (Ex1_Constructor)obj;
		ex1.show();
	}
}