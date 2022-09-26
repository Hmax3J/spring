package spring.core.ch02.ex02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // Aspect을 갖고 있는 Bean이다.
@Component
public class Timer {
	@Pointcut("execution(public * spring.core.ch02.ex02..*(..))") // ..는 0개 이상 뭐가 되어도 괜찮다는 뜻이다.
	private void myPointcut() {} // pointcut 이름을 정해준다. n개 생성이 가능하다.
	
	@Around("myPointcut()")
	public Object clock(ProceedingJoinPoint jp) throws Throwable {
		System.out.println(jp.getSignature());
		
		long start = System.currentTimeMillis();
		Result result = (Result)jp.proceed();
		long end = System.currentTimeMillis();
		
		System.out.println("경과시간: " + (end - start));
		
		result.setResult(result.getResult() + "(clock)");
		
		return result;
	}
}
