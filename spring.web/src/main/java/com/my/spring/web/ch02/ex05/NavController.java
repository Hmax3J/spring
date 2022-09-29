package com.my.spring.web.ch02.ex05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ch02/ex05")
public class NavController {
	@GetMapping("forward") // A forward B 는 같은 서버에 있을 때 사용한다.
	public String forward() { // url이 ch02/ex05/target으로 바뀌지 않는다.
		return "forward:target"; // 컨테이너가 url로 인식한다. target만 쓰면 viewName으로 인식한다.
	}
	
	@GetMapping("target")
	public String target() {
		return "ch02/ex05/target";
	}
	
	@GetMapping("redirect") // A redirect B 는 같은 서버나 다른 서버에 있을 때 사용한다.
	public String redirect() { // 클라이언트가 target으로 request로 보내서 url이 바뀐다.
		return "redirect:target"; // response에 담겨있다.
	}
	
//	ch02/ex05/naver로 request를 보내면 naver 사이트가 뜨도록 핸들러를 작성하라.
	@GetMapping("naver")
	public String redirectNaver() {
		return "redirect:https://www.naver.com";
	}
}
