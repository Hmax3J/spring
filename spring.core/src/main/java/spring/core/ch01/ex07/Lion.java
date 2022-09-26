package spring.core.ch01.ex07;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class Lion implements InitializingBean, DisposableBean {
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Lion is born.");
	}
	
	public void shout() {
		System.out.println("Lion shout.");
	}

	@Override
	public void destroy() throws Exception { // bean이 죽기 전에 청소 하려고 호출 하는 메서드다.
		System.out.println("Lion is dead.");
	}
}