package com.javaex.controller;

import com.javaex.dto.user.JoinDto;
import com.javaex.dto.user.JoinResponse;
import com.javaex.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/boggle/user")
public class UserController {//TODO: spring security 변경
	private final UserService userService;

	/*가입*/
	@PutMapping("/join")
	public JoinResponse join(@RequestBody JoinDto joinRequest) {
		log.info("join : {}", joinRequest);
		JoinResponse joinResult = userService.join(joinRequest);
		return joinResult;
	}
	
	/* 로그인 */
	/*@PostMapping("/login")
	public String login(@RequestBody UserVo userVo) {
		log.info("login:{}", );
		
		//유저 이메일, 패스워드 넣으면 넘버, 이름 주는 메소드
		UserVo authUser = userService.login(userVo);
		System.out.println("authUser : "+authUser);
		
		//로그인 성공여부 확인
		if(authUser != null) {
			//로그인 성공시
			System.out.println("로그인성공");
			
			//세션에 저장
			session.setAttribute("authUser", authUser);
			
			//리다이렉트
			return "redirect:/main";
		}else {
			System.out.println("로그인실패");
			
			String result = "fail";
			model.addAttribute("result", result);
			
			return "redirect:/user/loginForm";
		}
	}*/
	
	/*//* 로그아웃 *//*
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		
		System.out.println("UserController>logout");
		
		//세션정보 삭제
		httpSession.removeAttribute("authUser");
		httpSession.invalidate();
		
		return "redirect:/main";
	}
	
	//닉네임 체크
	@RequestMapping(value="/nicknameCheck")
    @ResponseBody
    public int nicknameCheck(@RequestParam("nickname") String nickname){
        
    	System.out.println("사용하고싶은 닉네임 : "+nickname);
        int cnt = userService.nickcheck(nickname);
        
        return cnt;
    }
	
	
	*//* 회원정보수정 *//*
	@RequestMapping("/user_modify")
	public String user_modify() {
		System.out.println("user_modify");
		
		return "user/user_modify";
	}*/

}