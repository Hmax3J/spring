package com.my.hr.web;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.my.hr.domain.Laborer;
import com.my.hr.service.LaborerService;

@RestController
@RequestMapping("laborer") // 매핑 url에 업무명을 쓴다. hr앱을 나타내는 url은 / 다.
public class LaborerController {
	@Autowired private LaborerService laborerService;
	
	@GetMapping
	public ModelAndView main(ModelAndView mv) {
		mv.setViewName("laborer/laborerMain");
		return mv;
	}
	
	@GetMapping("getLaborers") // 기능명을 포함한다.
	public List<Laborer> getLaborers() {
		return laborerService.getLaborers();
	}
	
	@PostMapping("addLaborer") // 2개는 파라미터
	public void addLaborer(String laborerName, 
			@DateTimeFormat(pattern="yyyy-MM-dd") LocalDate hireDate) {
		laborerService.addLaborer(laborerName, hireDate);
	}
	
	@PutMapping("fixLaborer") // 3개 이상은 커맨드
	public void fixLaborer(@RequestBody Laborer laborer) {
		laborerService.fixLaborer(laborer);
	}
	
	@DeleteMapping("delLaborer/{laborerId}") // 1개는 pathvariable을 이용한다.
	public void delLaborer(@PathVariable int laborerId) {
		laborerService.delLaborer(laborerId);
	}
}