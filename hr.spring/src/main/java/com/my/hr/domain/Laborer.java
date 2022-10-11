package com.my.hr.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Laborer { // 커맨드로 쓰려면 생성자 혹은 setter가 있어야 한다. 어트리뷰트로 쓰려면 getter가 있어야 한다.
	private int laborerId;
	private String laborerName;
	private LocalDate hireDate;
}