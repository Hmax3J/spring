package com.my.spring.web.ch02.ex04;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("ch02/ex04")
public class CheckController {
	@GetMapping
	public String main() {
		return "ch02/ex04/main";
	}
	
	@GetMapping("choice")
	public String choice(int kind) { // string이지만 int선언해서 자동 형변환 한다. requestParam의 특징이다. 
		String view = "ch02/ex04/";
		
		switch(kind) {
		case 1: view += "radioIn"; break;
		case 2: view += "checkboxIn";
		}
		
		return view;
	}
	
	/*
	@PostMapping("radio")
	public String radio(String agree, Model model) {
		model.addAttribute("agree", agree);
		return "ch02/ex04/radioOut";
	}
	*/
	
	@PostMapping("radio")
	public String radio(@ModelAttribute("agree") String agree) {
		return "ch02/ex04/radioOut";
	}
	
	/*
	@PostMapping("checkbox")
	public String checkbox(@RequestParam("fruit") List<String> fruits) { // ArrayList를 인식하지 못해서 RequestParam을 쓴다. 변수명과 넘어오는 값을 일치시킨다. RequestParam에 파라미터를 주면 매개변수 이름과 달라도 작동된다. 
		System.out.println(fruits);
		return "ch02/ex04/main"; // 처음엔 null을 주고 404에러가 뜨면 정상이다. 하나 하나 씩 쪼개서 개발을 해나간다.
	}
	
	@PostMapping("checkbox")
	public String checkbox(@RequestParam("fruit") @ModelAttribute("fruits") List<String> fruits) {  
		return "ch02/ex04/checkboxOut"; // 이렇게 하면 값이 안 넘어간다. @RequestParam과 @ModelAttribute 는 궁합이 안 맞다. 
	}
	*/
	
	@PostMapping("checkbox")
	public String checkbox(@RequestParam("fruit") List<String> fruits, Model fruit) {
		fruit.addAttribute("fruits", fruits);
		return "ch02/ex04/checkboxOut";
	}
}