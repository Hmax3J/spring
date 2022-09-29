package com.my.spring.web.ch02.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller("ch02.home")
@RequestMapping("ch02/home/number")
public class NumberController {
	@GetMapping
	public String numberIn() {
		return "ch02/home/numberIn";
	}
	
	@PostMapping
	public String numberOut(@ModelAttribute("number") NumberDto number) {
		double getNumber = number.getNaturalNumber();
		double x = Math.floor(((Math.random() * getNumber) + 1) * 10) / 10.0;
		
		if(getNumber <= x && x < getNumber + 1) {
			number.setNaturalNumber(x);
		}
		
		return "ch02/home/numberOut"; 
	}
}

/*
폼에 자연수 하나를 입력한다.
폼을 제출한다.
입력값 <= x < 입력값 + 1 인, x 를 출력한다.
x 는 실수이다.
x 는 랜덤값이다.
x 는 소수점 이하 한자리까지 표현한다.
*/