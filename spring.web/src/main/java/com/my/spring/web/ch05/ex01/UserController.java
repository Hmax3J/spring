package com.my.spring.web.ch05.ex01;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.spring.web.ch05.domain.User;

@RestController("ch05.ex01") // model과 view를 리턴하는게 아니고 model만 json 형태로 리턴한다.
@RequestMapping("ch05/ex01")
public class UserController {
	@GetMapping("main") // view라 html코드를 보낸다.
	public ModelAndView main(ModelAndView mv) { // rest에서 최초 view를 return 할 때 사용한다.
		mv.setViewName("ch05/ex01/main");
		return mv;
	}
	
	@GetMapping("get")
	public User get(User user) {
		return user;
	}
	
	@PostMapping("post") // 데이터 추가(쓰기)다. 클라이언트와 서버가 데이터를 주고 받을 때 전부 json형태다.
	public User post(@RequestBody User user) { // parameter를 전달 받는 방법. 4가지 CookieValue, RequestParam, PathVariable와 requestbody 
		return user;
	}
	
	@PutMapping("put") // 데이터 수정이다. 수정할 양이 많다.
	public User put(@RequestBody User user) {
		return user; 
	}
	
	@PatchMapping("patch") // 데이터 수정이다. 수정할 양이 적다.
	public User patch(@RequestBody User user) {
		return user;
	}
	
	@DeleteMapping("delete") // 데이터 삭제다.
	public User delete(@RequestBody User user) {
		return user;
	}
}
