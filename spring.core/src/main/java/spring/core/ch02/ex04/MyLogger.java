package spring.core.ch02.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogger {
	private final Logger logger;
	
	public MyLogger() {
		logger = LogManager.getLogger(MyLogger.class);
	}
	
	@After("@annotation(spring.core.ch02.ex04.Log)") // annotation을 이용해서 joinpoint를 선언한다.
	public void log(JoinPoint jp) {
		logger.info(jp.toShortString()); // 작업 시작했다 끝났다 라는 메세지다. 정상 작동 할 때 나타내는 메세지다.
	}
	
	@AfterThrowing(pointcut="@annotation(spring.core.ch02.ex04.Log)", throwing="ex")
	public void logError(JoinPoint jp, Throwable ex) { // 조인포인트가 실행 되었을 때 실행된다.
		logger.error(jp.toLongString() + ": " + ex.getMessage());
	}
}
