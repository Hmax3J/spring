package com.my.spring.web.ch02.ex02;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("ch02.ex02")
@RequestMapping("ch02/ex02") // Mapping id와 bean의 id는 유일해야 한다. 중복이 되면 안된다.
public class UserController {
	@GetMapping("userIn")
	public String userIn() {
		return "ch02/ex02/userIn"; // 해당되는 jsp 파일이 있는 경로를 적는다. 
	}
	/*
	@PostMapping("userOut")
	public String userOut(@RequestParam String userName,
							@RequestParam int age,
							@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate,
							Model model) {
		model.addAttribute("user", new User(userName, age, regDate));
		return "ch02/ex02/userOut";
	}
	*/
	@PostMapping("userOut")
	public String userOut(String userName, //RequestParam이 기본 값 이다.
							int age,
							@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate regDate,
							Model model) {
		model.addAttribute("user", new User(userName, age, regDate));
		return "ch02/ex02/userOut";
	}
}
