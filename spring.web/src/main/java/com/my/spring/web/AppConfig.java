package com.my.spring.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
	@Value("${attachPath}")
	private String attachPath;
	
	@Override // 화면 전용 뷰를 사용한다. 너무 간단한 것들을 구현하지 않고 이 메소드를 사용한다.
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("ch01/main"); // main화면이다. contextPath가 /다. /WEB-INF/view/ch01/main.jsp를 return한다.
//		registry.addViewController("ch02/ex03/user").setViewName("ch02/ex03/userIn");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("res/**").addResourceLocations("WEB-INF/res/"); // url이 res/** 이면 WEB-INF/res/ 로 url을 바꾼다.
		registry.addResourceHandler("attach/**").addResourceLocations("file:///" + attachPath + "/"); // 외부경로에 있는데 외부는 윈도우즈가 관리 하니 윈도우즈가 알아 볼 수 있는 주소를 입력한다.
	}
}
