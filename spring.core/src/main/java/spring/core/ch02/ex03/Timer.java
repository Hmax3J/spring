package spring.core.ch02.ex03;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Timer {
	@Before("execution(* spring..*(int))") // joinpoint 이전에 실행된다.
	public void clockStart(JoinPoint jp) {
		System.out.println(jp.toShortString());
		System.out.println("시작 시각: " + LocalDateTime.now());
	}
	
	@After("within(spring..Calculator)") // class명만 기술한다. spring으로 시작하고 Calculator로 끝나는 클래스안에 있는 메서드를 지칭한다.
	public void clockEnd(JoinPoint jp) { // After Advice 는 joinpoint 후에 실행된다.
		System.out.println(jp.toShortString());
		System.out.println("종료 시각: " + LocalDateTime.now());
	}
	
	@AfterReturning(pointcut="bean(calc*)", returning="result") // joinpoint가 실행 성공 되었을 때 실행된다.
	public void printResult(JoinPoint jp, int result) { // After보다 우선순위가 높다. 먼저 실행된다.
		System.out.println(jp.toShortString() + ": " + result);
	}
}
