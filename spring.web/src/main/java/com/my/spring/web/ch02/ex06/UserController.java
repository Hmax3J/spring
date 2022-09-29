package com.my.spring.web.ch02.ex06;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("ch02.ex06")
@RequestMapping("ch02/ex06")
public class UserController {
	@GetMapping("login")
	public String loginIn(@CookieValue(required=false) String userId, // required false로 하면 cookie 아니면 말고 라는 뜻이다. 해당 쿠키가 존재하지 않으면 null을 값으로 전달받게 된다.
			@ModelAttribute("user") UserDto user) { // required=true 로 하면 Exception이 발생한다.
		if(userId != null) user.setUserId(userId);
		return "ch02/ex06/login"; // user와 view를 매핑해서 디스패처에게 return 한다.
	}
	
	@PostMapping("login") // session에 아이디가 있다 없다 로 로그인을 했는가 안했는가를 나타낸다.
	public String login(@ModelAttribute("user") UserDto user, String rememberMe,
			HttpSession session, HttpServletResponse response) {
		if(session.getAttribute("userId") == null)
			session.setAttribute("userId", user.getUserId());
		
		if(rememberMe != null && rememberMe.equals("on")) {
			Cookie cookie = new Cookie("userId", user.getUserId());
			cookie.setMaxAge(5);
			response.addCookie(cookie);
		}
		
		return "ch02/ex06/logout";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login";
	}
}
