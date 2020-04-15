import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

class Client_Autodetect {
	public static void main(String[] args) {
		Resource resource = new ClassPathResource("spconfig_autodetect.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		Ex1_Autodetect ex1 = (Ex1_Autodetect)factory.getBean("ex1");
		ex1.show();
	}
}