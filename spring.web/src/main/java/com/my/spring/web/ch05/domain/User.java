package com.my.spring.web.ch05.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class User {
	private int userId;
	private String userName;
	@DateTimeFormat(pattern="yyyy-MM-dd") // requestparam을 localdate로 바꿔준다.
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Seoul") // localdate를 json으로 바꿔준다.
	private LocalDate birthday; // 클라이언트에서 birthday를 입력하면 datetimeformat을 사용한다.
}
