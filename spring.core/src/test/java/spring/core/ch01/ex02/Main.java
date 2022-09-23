package spring.core.ch01.ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app.xml", Main.class);
		
		Shooter shooter1 = ctx.getBean("shooter1", Shooter.class); // shooter1은 object타입 이지만 사용하려면 본래 타입으로 캐스팅 해야한다. 2 번째 파라미터가 알아서 캐스팅한다.
		Shooter shooter2 = ctx.getBean("shooter2", Shooter.class); // new는 container가 하고있고 여기서는 꺼내오기만 한다.
		
		shooter1.fire();
		shooter2.fire();
	}
}
