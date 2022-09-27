package com.my.spring.web.ch02.ex01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // setter getter 를 만들어라 라는 뜻이다. 동시에 만든다.
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private String userName;
	private int age;
}
