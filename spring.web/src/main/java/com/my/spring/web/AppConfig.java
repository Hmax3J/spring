package com.my.spring.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Override // 화면 전용 뷰를 사용한다. 너무 간단한 것들을 구현하지 않고 이 메소드를 사용한다.
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ch01/main"); // main화면이다. contextPath가 /다. /WEB-INF/view/ch01/main.jsp를 return한다.
	}
}
