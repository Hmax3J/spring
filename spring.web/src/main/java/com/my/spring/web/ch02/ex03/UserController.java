package com.my.spring.web.ch02.ex03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex03") // bean id의 값은 유일해야 한다.
@RequestMapping("ch02/ex03/user") // url값은 유일해야 한다.
public class UserController { // 1차로 일반적인 controller를 먼저 실행한다.
	@GetMapping // parameter가 없으면 ch02/ex03/user가 url이 된다.
	public String userIn() {
		return "ch02/ex03/userIn";
	}
	
	@PostMapping // user업무의 입력과 출력이라 url을 같게 해준다. request method 값이 달라 문제가 없다.
	public String userOut(User user) {
		return "ch02/ex03/userOut";
	}
}
