package spring.core.ch01.ex03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.core.ch01.ex01.Pistol;
import spring.core.ch01.ex01.Rifle;
import spring.core.ch01.ex02.Shooter;

@Configuration // 컨테이너가 내부적으로 사용하는 Bean 이다. 컨테이너가 읽어들인다.
public class AppConfig {
	@Bean // 업무에 사용하지 않고 ioc에 사용한다는 것을 나타낸다.
	public Pistol pistol() {
		return new Pistol(); // 단점은 new 를 직접 써야한다.
	}
	
	@Bean
	public Rifle rifle() { // 메서드가 bean의 id로 사용되기 때문에 메서드 이름이 명사다.
		return new Rifle();
	}
	
	@Bean
	public Shooter shooter1() {
		return new Shooter("최한석", pistol());
	}
	
	@Bean
	public Shooter shooter2() {
		Shooter shooter = new Shooter();
		shooter.setName("한아름");
		shooter.setGun(rifle());
		
		return shooter;
	}
}
