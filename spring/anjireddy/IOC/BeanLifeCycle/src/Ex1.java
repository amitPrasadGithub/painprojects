import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Ex1 implements InitializingBean, DisposableBean {

	@Override
	public void destroy() throws Exception {
		System.out.print("\n Destroying");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.print("\n after prop");
	}
	
	
}
