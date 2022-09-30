package com.my.spring.web.ch03.ex02;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller("ch03.ex02")
@RequestMapping("ch03/ex02/user")
public class UserController {
	@Value("${attachPath}") private String attachPath;
	
	@GetMapping
	public String userIn() {
		return "ch03/ex02/userIn";
	}
	
	@PostMapping // 바이너리는 txt가 아니라 url이 될 수 없다. 파일이 하나라도 있으면 post가 된다.
	public String userOut(UserDto userDto, HttpServletRequest request, User user) {
		String fileName = userDto.getFace().getOriginalFilename(); // 클라이언트가 가지고 있는 파일명을 지칭한다.
		saveFile(attachPath + "/" + fileName, userDto.getFace());
		
		user.setFaceFileName(fileName);
		
		return "ch03/ex02/userOut";
	}
	
	private void saveFile(String fileName, MultipartFile file) {
		try {
			file.transferTo(new File(fileName));
		} catch(IOException e) {}
	}
}
