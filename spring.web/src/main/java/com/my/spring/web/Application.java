package com.my.spring.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.my.spring.web.**.map") // 매퍼는 여기 정의한다.
//@MapperScan("com.my.spring.web.**.dao.map") // 이렇게도 쓸 수 있다.
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}