package spring.core.ch01.ex08;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring.core.ch01.ex08.AppConfig;
import spring.core.ch01.ex08.Lapin;
import spring.core.ch01.ex08.Leopard;
import spring.core.ch01.ex08.Lion;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Lion lion1 = ctx.getBean(Lion.class);
		Lion lion2 = ctx.getBean(Lion.class); // singleton 이라 하나의 bean을 계속 return 한다. 
		
		Leopard leopard1 = ctx.getBean(Leopard.class);
		Leopard leopard2 = ctx.getBean(Leopard.class);
		
		Lapin lapin1 = ctx.getBean(Lapin.class);
		Lapin lapin2 = ctx.getBean(Lapin.class); // scope이 prototype이라 bean을 요청 할 때 마다 새로운 bean을 만들어서 return 한다.
		
		System.out.println("Lion: " + (lion1 == lion2));
		System.out.println("Leopard: " + (leopard1 == leopard2));
		System.out.println("Lapin: " + (lapin1 == lapin2));
	}
}
