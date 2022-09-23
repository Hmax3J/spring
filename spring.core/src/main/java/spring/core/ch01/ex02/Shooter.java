package spring.core.ch01.ex02;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import spring.core.ch01.ex01.Gun;

@Setter // Setter를 lombok으로 만들어라 라는 뜻이다.
@NoArgsConstructor // parameter가 없는 생성자 만든다.
@AllArgsConstructor // parameter가 있는 생성자를 만든다.
public class Shooter {
	private String name;
	private Gun gun;
	
	public void fire() {
		System.out.print(name + ": ");
		gun.fire();
	}
}
