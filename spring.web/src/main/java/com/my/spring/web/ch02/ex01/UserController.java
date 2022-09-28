package com.my.spring.web.ch02.ex01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // 리퀘스트를 받을 수 있다. presentation 계층에 속한다. 실제로는 dispatcher이 request를 받는다.
@RequestMapping("ch02/ex01") // 핸들러들의 공통 url을 적는다.
public class UserController {
	@GetMapping("11") // ch02/ex01/11 와 UserController.handler11을 매핑한다. url이 contextpath 이후의 url을 말한다.
	public ModelAndView handler11(ModelAndView mv) { // ch02/ex01/11이 handler11의 이름이다. handler mapping 에 등록이 된다.
		mv.addObject("user", new User("최한석", 11)); // 모델 이름, 모델 밸류 , atrributeName, Value
		mv.setViewName("ch02/ex01/user"); // view name 임의로 정한다.
		
		return mv; // 리턴이 model and view 
	}
	
	@GetMapping("21") // annotation이 붙어있지 않으면 핸들러가 아니다.
	public String handler21(Model model) {
		model.addAttribute("user", new User("한아름", 21)); // 뷰를 공유하려고 모델 이름을 같게 만들었다.
		return "ch02/ex01/user"; // view name으로 쓰인다. handler Adapter가 모델과 뷰를 구분한다.
	}
	
	@GetMapping("22")
	public String handler22() { // 모델은 return 하지 않겠다 라는 의도다.
		return "ch02/ex01/user"; // view만 return 한다. 모델은 안써도 view는 보내야 한다.
	}
	
	@GetMapping("31") // 31이면 31.jsp라는 파일이 있어야 한다.
	public void handler31(User user) { // 핸들러에 붙어 있는 url이 view Name이 된다.
		user.setUserName("양승일"); // 파라미터 안에 클래스 이름의 소문자가 모델 이름이 된다.
		user.setAge(31);
	}
	
	@GetMapping("32") // ch02/ex01/32 가 view name 이고 man이 modelname이 된다.
	public void handler32(@ModelAttribute("man") User user) { // attributeName을 내가 정할 수 있다.
		user.setUserName("서준한");
		user.setAge(32);
	}
	
	@GetMapping("41")
	public User handler41(User user) { // return 타입 이름의 소문자가 modelName이 된다.
		user.setUserName("김가람");
		user.setAge(41);
		
		return user; // viewName은 handler mapping으로 자동 생성한다.
	}
	
	@GetMapping("42")
	@ModelAttribute("man") // modelName을 내가 설정 할 수 있다.
	public User handler42(User user) {
		user.setUserName("박건우");
		user.setAge(42);
		
		return user;
	}
}
