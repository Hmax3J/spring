package com.my.spring.web.ch02.ex01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // setter getter 를 만들어라 라는 뜻이다. 동시에 만든다.
@NoArgsConstructor // 기본 생성자를 만든다.
@AllArgsConstructor // 파라미터를 가진 필드로 만든다.
public class User {
	private String userName;
	private int age;
}
