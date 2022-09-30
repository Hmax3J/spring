package com.my.spring.web.ch03.ex02;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UserDto { // 클라이언트와 서버사이의 주고받을 용도로 만들었다.
	private String userName;
	private int age; 
	private MultipartFile face; // 첨부파일의 타입이다. 첨부파일 기능을 만든게 아니고 첨부파일은 데이터타입 일 뿐이다.
}
