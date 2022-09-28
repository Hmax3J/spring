package com.my.spring.web.ch02.ex03;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
	private String userName;
	private int age;
	@DateTimeFormat(pattern="yyyy-MM-dd") // User를 커맨드로 쓰려고 선언했다.
	private LocalDate regDate;
}
