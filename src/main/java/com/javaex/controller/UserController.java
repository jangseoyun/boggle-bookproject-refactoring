package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	//필드
	@Autowired
	private UserService userService;
	
	
	/* 로그인폼 */
	@RequestMapping("/loginForm")
	public String loginForm() {
		System.out.println("UserController>loginForm");
		
		return "user/loginForm";
	}
	
	/* 로그인 */
	@RequestMapping("/login")
	public String login(Model model,
						@ModelAttribute UserVo userVo,
						HttpSession session) {
		System.out.println("UserController>login");
		
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
	}
	
	/* 로그아웃 */
	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		
		System.out.println("UserController>logout");
		
		//세션정보 삭제
		httpSession.removeAttribute("authUser");
		httpSession.invalidate();
		
		return "redirect:/main";
	}
	
	
	/* 회원가입 */
	@RequestMapping("/joinForm")
	public String joinForm() {
		System.out.println("joinForm");
		
		return "user/joinForm";
	}
	
	/*가입*/
	@RequestMapping(value="/join", method={RequestMethod.GET, RequestMethod.POST})
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("UserController > join");
		
		System.out.println(userVo);
		//파라미터값 넣은 userVo 넣어주는 insert 메소드 이용
		userService.insert(userVo);	
		
		return "user/loginForm";
	}
	
	//닉네임 체크
	@RequestMapping(value="/nicknameCheck")
    @ResponseBody
    public int nicknameCheck(@RequestParam("nickname") String nickname){
        
    	System.out.println("사용하고싶은 닉네임 : "+nickname);
        int cnt = userService.nickcheck(nickname);
        
        return cnt;
    }
	
	
	/* 회원정보수정 */
	@RequestMapping("/user_modify")
	public String user_modify() {
		System.out.println("user_modify");
		
		return "user/user_modify";
	}
	
	
	
	

}