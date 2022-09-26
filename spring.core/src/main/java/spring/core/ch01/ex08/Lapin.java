package spring.core.ch01.ex08;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Lapin이 n개 생길 것 이다. 라는 것을 의미한다.
public class Lapin {
	
}
