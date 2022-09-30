package com.my.spring.web.ch03.ex02;

import lombok.Data;

@Data
public class User { // DB에 저장할 도메인이다.
	private String userName;
	private int age; // DB에는 파일 이름을 저장한다.
	private String faceFileName; // 첨부파일이 필요한 게 아니고 첨부파일 명이 필요해 String 선언했다.
}
