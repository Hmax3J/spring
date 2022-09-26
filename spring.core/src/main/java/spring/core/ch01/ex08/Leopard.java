package spring.core.ch01.ex08;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton") // scope을 설정하지 않으면 기본 값은 singleton이다. 1개만 사용 한다는 뜻이다.
public class Leopard {
	
}
