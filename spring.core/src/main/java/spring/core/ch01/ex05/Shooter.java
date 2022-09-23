package spring.core.ch01.ex05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component // ioc를 표현한다.
public class Shooter {
	@Autowired @Nullable private Gun pistol; // Autowired는 di를 표현한다.
	@Autowired @Nullable private Gun rifleGun; // bean이 2개 이상이면 타입으로 검색하고 동일한 타입이 있으면 변수명과 id가 일치하는 것을 찾는다.
	
	public void fire() {
		try {
			pistol.fire();
			rifleGun.fire();
		} catch(Exception e) {}
	}
}