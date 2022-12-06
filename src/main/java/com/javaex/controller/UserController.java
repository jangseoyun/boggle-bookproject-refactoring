package com.javaex.controller;

import com.javaex.dto.user.JoinDto;
import com.javaex.dto.user.UserResponse;
import com.javaex.dto.user.LoginRequest;
import com.javaex.dto.user.LoginResponse;
import com.javaex.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boggle/user")
public class UserController {//TODO: spring security 변경
	private final UserService userService;

	/*가입*/
	@PutMapping("/join")
	public UserResponse join(@RequestBody JoinDto joinRequest) {
		log.info("join : {}", joinRequest);
		UserResponse joinResult = userService.join(joinRequest);
		return joinResult;
	}
	
	/* 로그인 */
	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest loginRequest) {//email, password
		log.info("login:{}", loginRequest);
		String token = userService.login(loginRequest);
		return new LoginResponse(token);
	}
	
	/*//* 로그아웃 *//*
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		System.out.println("UserController>logout");
		
		//세션정보 삭제
		httpSession.removeAttribute("authUser");
		httpSession.invalidate();
		
		return "redirect:/main";
	}

	*//* 회원정보수정 *//*
	@RequestMapping("/user_modify")
	public String user_modify() {
		System.out.println("user_modify");
		return "user/user_modify";
	}*/

}