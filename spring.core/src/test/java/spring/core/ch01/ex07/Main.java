package spring.core.ch01.ex07;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Lion lion = ctx.getBean(Lion.class); // singletone 이면 데이터 타입으로도 할 수 있다.
		lion.shout(); 
					 // bean을 죽이는 메서드가 없다. 그래서 컨테이너를 닫는다.
		ctx.close(); // close를 사용하려고 컨테이너를 AnnotationConfigApplicationContext 로 만들었다.
	}
}
